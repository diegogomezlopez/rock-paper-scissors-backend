package com.diegogomezlopez.rockpaperscissors.controller;

import com.diegogomezlopez.rockpaperscissors.controllers.RoundHistoryController;
import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.dto.RoundHistoryDTO;
import com.diegogomezlopez.rockpaperscissors.mapper.RoundHistoryMapper;
import com.diegogomezlopez.rockpaperscissors.services.RoundHistoryService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RoundHistoryControllerTest {

    @InjectMocks
    private RoundHistoryController roundHistoryController;

    @Mock
    RoundHistoryMapper roundHistoryMapper;

    @Mock
    RoundHistoryService roundHistoryService;

    MockMvc mockMvc;

    @BeforeEach
    public void init() {

        mockMvc = MockMvcBuilders.standaloneSetup(roundHistoryController).build();
    }

    @Test
    public void update_whenRoundPlayed_thenUpdateRoundHistory() throws Exception {
        RoundHistory roundHistory = RoundHistory.builder()
                .player1Wins(0)
                .player2Wins(1)
                .totalDraws(2)
                .roundsPlayed(3)
                .build();
        RoundHistoryDTO roundHistoryDTO = RoundHistoryDTO.builder()
                .player1Wins(0)
                .player2Wins(1)
                .totalDraws(2)
                .totalDraws(3)
                .build();

        when(roundHistoryService.find()).thenReturn(roundHistory);
        when(roundHistoryMapper.roundHistoryToRoundHistoryDTO(roundHistory)).thenReturn(roundHistoryDTO);

        mockMvc.perform(get(RoundHistoryController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.player1Wins", equalTo(roundHistoryDTO.getPlayer1Wins())))
                .andExpect(jsonPath("$.player2Wins", equalTo(roundHistoryDTO.getPlayer2Wins())))
                .andExpect(jsonPath("$.totalDraws", equalTo(roundHistoryDTO.getTotalDraws())))
                .andExpect(jsonPath("$.roundsPlayed", equalTo(roundHistoryDTO.getRoundsPlayed())));
    }

}
