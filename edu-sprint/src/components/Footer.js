import { Box, Typography, Link } from '@mui/material';

const Footer = () => {
    return (
        <Box
            sx={{
                bgcolor: 'primary.main',
                color: 'white',
                py: 2,
                textAlign: 'center',
            }}
        >
            <Typography variant="body2">
                EduSprint © 2024. All rights reserved.
            </Typography>
            <Typography variant="body2">
                <Link href="mailto:support@edusprint.com" sx={{ color: 'white' }}>support@edusprint.com</Link>
            </Typography>
        </Box>
    );
};

export default Footer;
