package com.diegogomezlopez.rockpaperscissors.mapper;

import com.diegogomezlopez.rockpaperscissors.domain.Move;
import com.diegogomezlopez.rockpaperscissors.domain.Result;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.dto.RoundResultDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoundResultMapperTest {

    private final RoundResultMapper roundResultMapper = RoundResultMapper.INSTANCE;

    private Move player1Move;
    private Move player2Move;
    private Result result;

    @BeforeEach
    public void init() {
        player1Move = Move.ROCK;
        player2Move = Move.PAPER;
        result = Result.LOSE;
    }

    @Test
    public void roundResultToRoundResultDTO_whenValidInput_thenDTOReturned() {
        RoundResult roundResult = RoundResult.builder()
                .player1Move(player1Move)
                .player2Move(player2Move)
                .result(result)
                .build();

        RoundResultDTO roundResultDTO = roundResultMapper.roundResultToRoundResultDTO(roundResult);

        assertEquals(roundResult.getPlayer1Move().getMove(), roundResultDTO.getPlayer1Move());
        assertEquals(roundResult.getPlayer2Move().getMove(), roundResultDTO.getPlayer2Move());
        assertEquals(roundResult.getResult().getResult(), roundResultDTO.getResult());
    }
}
