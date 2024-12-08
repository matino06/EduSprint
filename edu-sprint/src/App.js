import './App.css';
import React from 'react';
import { Box, ThemeProvider, Typography, Container } from '@mui/material';

import { UserProvider, useUser } from './context/UserContext';
import theme from './styles/theme';
import Navbar from './components/Navbar';
import Footer from './components/Footer';

function App() {
  const user = useUser();

  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'column',
          minHeight: '100vh',
        }}>
        <UserProvider>
          <Navbar />
          <Container sx={{
            flex: 1,
          }}>
            <UserGreeting />
          </Container>
          <Footer />
        </UserProvider>
      </Box>
    </ThemeProvider>
  );
}

function UserGreeting() {
  const user = useUser();

  return (
    <Typography variant="h1">
      {user ? (
        <p>Welcome, {user.displayName}</p>
      ) : (
        <p>Please log in</p>
      )}
    </Typography>
  );
}

export default App;
