import { createTheme } from '@mui/material';

const theme = createTheme({
    palette: {
        primary: {
            main: "#399918",
        },
        secondary: {
            main: "#FFAAAA",
        },
        accent: {
            main: "#FF7777",
        },
        textBlack: {
            main: "#1E1E1E",
        },
        textWhite: {
            main: "#ECFFE6",
        },
        backgroundWhite: {
            main: "#ECFFE6",
            contrastText: '#399918',
        },
    },
    typography: {
        fontFamily: '"Roboto", "Helvetica", "Arial", sans-serif',
        fontSize: 16,
        h1: {
            fontSize: '3rem',
        },
        h2: {
            fontSize: '2.5rem',
        },
        body1: {
            fontSize: '1.5rem',
        },
    },
});

export default theme;