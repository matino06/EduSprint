import React, { useState } from 'react';
import { Box, Typography, styled, Card, CardMedia } from '@mui/material';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import { MathJax, MathJaxContext } from 'better-react-mathjax';

import TaskDifficultySelector from './TaskDifficultySelector';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
  variants: [
    {
      props: ({ expand }) => !expand,
      style: {
        transform: 'rotate(0deg)',
      },
    },
    {
      props: ({ expand }) => !!expand,
      style: {
        transform: 'rotate(180deg)',
      },
    },
  ],
}));

export default function TaskReviewCard() {
  const [expanded, setExpanded] = useState(false);

  const latex = 'f(x) = 2 \\sin(Bx)';

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
    <MathJaxContext>
      <Card sx={{ maxWidth: 550, bgcolor: 'backgroundWhite.main' }}>
        <CardHeader
          title="Funkcije i nizovi"
          subheader="Analizira graf trigonometrijskih
        funkcija."
        />
        <CardContent>
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            <MathJax dynamic>
              {`Na slici je prikazan graf funkcije \\( ${latex} \\)`}
            </MathJax>
          </Typography>
          <CardMedia
            sx={{ py: 2, }}
            component="img"
            height="320"
            image="/myplot.png"
            alt="Plot"
          />
          <Typography variant="body2" sx={{ color: 'text.secondary' }}>
            <MathJax dynamic>
              {`Odredite vrijednost parametra \\(B \\).`}
            </MathJax>
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ExpandMoreIcon />
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent>
            <Typography variant="body2" sx={{ marginBottom: 2 }}>
              <MathJax>{`1. Primjećujemo da u \\(x = 2\\pi\\) funkcija poprima vrijednost \\(0\\).`}</MathJax>
              <Box sx={{ height: '16px' }} />
              <MathJax>{`2. Postavljamo jednađbu \\( 2sin(B2\\pi) = 0.\\)`}</MathJax>
              <Box sx={{ height: '16px' }} />
              <MathJax>{`3. Riješiti jednađbu ili ubaciti u kalkulator.`}</MathJax>
              <Box sx={{ height: '16px' }} />
              <MathJax>{`\\(=> B = \\frac{3}{2} \\)`}</MathJax>
            </Typography>
            <TaskDifficultySelector />
          </CardContent>
        </Collapse>
      </Card>
    </MathJaxContext>
  );
}
