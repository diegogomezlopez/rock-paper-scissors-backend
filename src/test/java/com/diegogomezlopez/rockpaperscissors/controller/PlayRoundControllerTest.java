package com.diegogomezlopez.rockpaperscissors.controller;

import com.diegogomezlopez.rockpaperscissors.controllers.PlayRoundController;
import com.diegogomezlopez.rockpaperscissors.domain.Move;
import com.diegogomezlopez.rockpaperscissors.domain.Result;
import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.dto.RoundResultDTO;
import com.diegogomezlopez.rockpaperscissors.mapper.RoundResultMapper;
import com.diegogomezlopez.rockpaperscissors.services.RoundHistoryService;
import com.diegogomezlopez.rockpaperscissors.services.RoundResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PlayRoundControllerTest {

    @InjectMocks
    private PlayRoundController playRoundController;

    @Mock
    RoundResultMapper roundResultMapper;

    @Mock
    RoundResultService roundResultService;

    @Mock
    RoundHistoryService roundHistoryService;

    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(playRoundController).build();
    }

    @Test
    public void playRound_whenPlayRound_thenReturnRoundResultDTO() throws Exception {
        RoundResult roundResult = RoundResult.builder()
                .player1Move(Move.ROCK)
                .player2Move(Move.SCISSORS)
                .result(Result.WIN)
                .build();
        RoundResultDTO roundResultDTO = RoundResultDTO.builder()
                .player1Move(roundResult.getPlayer1Move().getMove())
                .player2Move(roundResult.getPlayer2Move().getMove())
                .result(roundResult.getResult().getResult())
                .build();
        RoundHistory roundHistory = RoundHistory.builder()
                .player1Wins(0)
                .player2Wins(0)
                .totalDraws(0)
                .roundsPlayed(0)
                .build();

        when(roundResultMapper.roundResultToRoundResultDTO(any(RoundResult.class))).thenReturn(roundResultDTO);
        when(roundResultService.getRoundResult(any(Move.class), any(Move.class))).thenReturn(roundResult);
        when(roundHistoryService.update(any(RoundResult.class))).thenReturn(roundHistory);

        mockMvc.perform(get(PlayRoundController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", equalTo(roundResultDTO.getResult())))
                .andExpect(jsonPath("$.player1Move", equalTo(roundResultDTO.getPlayer1Move())))
                .andExpect(jsonPath("$.player2Move", equalTo(roundResultDTO.getPlayer2Move())));
    }
}
