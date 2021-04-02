package com.diegogomezlopez.rockpaperscissors.services.impl;

import com.diegogomezlopez.rockpaperscissors.domain.Move;
import com.diegogomezlopez.rockpaperscissors.domain.Result;
import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoundHistoryServiceImplTest {

    @InjectMocks
    private RoundHistoryServiceImpl roundHistoryService;

    private RoundResult roundResult;

    @BeforeEach
    public void init() {
        roundResult = RoundResult.builder()
                .player1Move(Move.ROCK)
                .player2Move(Move.SCISSORS)
                .result(Result.WIN)
                .build();
        RoundHistory roundHistory = RoundHistory.builder()
                .player1Wins(0)
                .player2Wins(0)
                .totalDraws(0)
                .roundsPlayed(0)
                .build();
        roundHistoryService.save(roundHistory);
    }

    @Test
    public void update_whenPLayer1Win_thenIncreasePlayer1Wins() {
        Integer player1Wins = roundHistoryService.find().getPlayer1Wins();
        roundResult = RoundResult.builder()
                .player1Move(Move.SCISSORS)
                .player2Move(Move.PAPER)
                .result(Result.WIN)
                .build();

        RoundHistory roundHistory = roundHistoryService.update(roundResult);

        assertEquals(++player1Wins, roundHistory.getPlayer1Wins());

    }

    @Test
    public void update_whenPLayer1Lose_thenIncreasePlayer2Wins() {
        Integer player2Wins = roundHistoryService.find().getPlayer2Wins();
        roundResult = RoundResult.builder()
                .player1Move(Move.ROCK)
                .player2Move(Move.PAPER)
                .result(Result.LOSE)
                .build();

        RoundHistory roundHistory = roundHistoryService.update(roundResult);

        assertEquals(++player2Wins, roundHistory.getPlayer2Wins());

    }

    @Test
    public void update_whenDraw_thenIncreaseDraws() {
        Integer totalDraws = roundHistoryService.find().getTotalDraws();
        roundResult = RoundResult.builder()
                .player1Move(Move.ROCK)
                .player2Move(Move.ROCK)
                .result(Result.DRAW)
                .build();

        RoundHistory roundHistory = roundHistoryService.update(roundResult);

        assertEquals(++totalDraws, roundHistory.getTotalDraws());
    }

    @Test
    public void update_whenNewRound_thenIncreaseRoundsPlayed() {
        Integer roundsPlayed = roundHistoryService.find().getRoundsPlayed();

        RoundHistory roundHistory = roundHistoryService.update(roundResult);

        assertEquals(++roundsPlayed, roundHistory.getRoundsPlayed());
    }
}
