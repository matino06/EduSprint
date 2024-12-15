import React from 'react';
import { Radio, RadioGroup, FormControlLabel, FormControl, FormLabel, Button, Tooltip } from '@mui/material';

const TaskDifficultySelector = ({ onDifficultySelect, selectedDifficulty }) => {
    const difficultyLevels = [
        { label: 'Potpuni zaborav', value: 0, color: '#ff9800' },
        { label: 'Netočan odgovor, ispravan je zapamćen', value: 1, color: '#ffc107' },
        { label: 'Netočan odgovor, iako se ispravan činio lako pamtljivim', value: 2, color: '#ffeb3b' },
        { label: 'Točan odgovor prisjećan s ozbiljnim poteškoćama', value: 3, color: '#cddc39' },
        { label: 'Točan odgovor nakon oklijevanja', value: 4, color: '#8bc34a' },
        { label: 'Savršen odgovor', value: 5, color: '#399918' },
    ];

    return (
        <FormControl component="fieldset"
            sx={{
                flex: 1,
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
            }}>
            <FormLabel component="legend" sx={{
                color: 'primary.main'
            }} >Odaberite težinu zadatka</FormLabel>
            <RadioGroup
                value={selectedDifficulty}
                // onChange={(event) => onDifficultySelect(event.target.value)}
                row
            >
                {difficultyLevels.map((level) => (
                    <FormControlLabel
                        key={level.value}
                        value={level.value}
                        control={
                            <Tooltip title={level.label} arrow>
                                <Radio
                                    sx={{
                                        color: level.color,
                                        '&.Mui-checked': {
                                            color: level.color,
                                        }
                                    }}
                                />
                            </Tooltip>
                        }
                    />
                ))}
                <Button sx={{
                    backgroundColor: 'primary.main',
                    color: 'textWhite.main'
                }}>
                    Sljedeći
                </Button>
            </RadioGroup>
        </FormControl>
    );
};

export default TaskDifficultySelector;
