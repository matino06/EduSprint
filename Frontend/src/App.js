import './App.css';
import React from 'react';
import { Box, ThemeProvider, Typography, Container } from '@mui/material';
import { UserProvider, useUser } from './context/UserContext';
import theme from './styles/theme';
import Navbar from './components/navbar/Navbar';
import Footer from './components/footer/Footer';
import TaskReviewCard from './components/card/Card';

function App() {
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
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            py: 2,
          }}>
            <Task />
          </Container>
          <Footer />
        </UserProvider>
      </Box>
    </ThemeProvider>
  );
}

function Task() {
  const user = useUser();

  return (
    <Typography variant="h1">
      {user ? (
        <TaskReviewCard />
      ) : (
        <p>Please log in</p>
      )}
    </Typography>
  );
}

export default App;
