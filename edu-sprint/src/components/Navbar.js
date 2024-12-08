import React, { useState } from 'react';
import { AppBar, Toolbar, Button, Box, Container } from '@mui/material';
import { Google } from '@mui/icons-material';

import { useUser } from '../context/UserContext';
import { auth, googleProvider } from '../config/firebase-config';
import { signInWithPopup, signOut } from 'firebase/auth';

const Navbar = () => {
    const user = useUser();

    // Function to handle Google login
    const handleGoogleLogin = async () => {
        try {
            if (user) {
                await signOut(auth);
                console.log("User signed out");
            } else {
                const result = await signInWithPopup(auth, googleProvider);
                // The signed-in user info
                const user = result.user;
                console.log(user);
            }

        } catch (error) {
            console.error(`Error during ${user ? 'Sign Out' : 'Google Sign In'}`, error.message);
        }
    };

    return (
        <AppBar position="static" color="primary">
            <Container>
                <Toolbar>
                    {/* Left-aligned navigation links */}
                    <Box sx={{ display: 'flex', gap: 2, flexGrow: 1 }}>
                        <Button color="inherit">Vježbaj</Button>
                        <Button color="inherit">Kako funkcionira</Button>
                        <Button color="inherit">Opcije</Button>
                    </Box>
                    {/* Right-aligned button */}
                    <Button
                        onClick={handleGoogleLogin}
                        variant="contained"
                        color="backgroundWhite"
                        startIcon={!user && <Google />}
                    >
                        {user ? "Odjava" : "Google Prijava"}
                    </Button>
                </Toolbar>
            </Container>

        </AppBar >
    );
};

export default Navbar;
