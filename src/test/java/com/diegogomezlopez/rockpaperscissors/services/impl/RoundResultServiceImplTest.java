package com.diegogomezlopez.rockpaperscissors.services.impl;

import com.diegogomezlopez.rockpaperscissors.domain.Move;
import com.diegogomezlopez.rockpaperscissors.domain.Result;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoundResultServiceImplTest {

    @InjectMocks
    private RoundResultServiceImpl roundResultService;

    @Test
    public void getRoundResult_whenPlayer1DefeatPlayer2_thenWinResult() {
        Move player1Move = Move.ROCK;
        Move player2Move = Move.SCISSORS;

        RoundResult roundResult = roundResultService.getRoundResult(player1Move, player2Move);

        assertEquals(roundResult.getResult(), Result.WIN);
    }

    @Test
    public void getRoundResult_whenPlayer2DefeatPlayer1_thenLoseResult() {
        Move player1Move = Move.PAPER;
        Move player2Move = Move.SCISSORS;

        RoundResult roundResult = roundResultService.getRoundResult(player1Move, player2Move);

        assertEquals(roundResult.getResult(), Result.LOSE);
    }

    @Test
    public void getRoundResult_whenSameMoves_thenDrawResult() {
        Move player1Move = Move.PAPER;
        Move player2Move = Move.PAPER;

        RoundResult roundResult = roundResultService.getRoundResult(player1Move, player2Move);

        assertEquals(roundResult.getResult(), Result.DRAW);
    }
}
