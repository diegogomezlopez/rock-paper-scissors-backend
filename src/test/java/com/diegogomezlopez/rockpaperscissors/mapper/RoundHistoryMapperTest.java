package com.diegogomezlopez.rockpaperscissors.mapper;

import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.dto.RoundHistoryDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundHistoryMapperTest {

    private final RoundHistoryMapper roundHistoryMapper = RoundHistoryMapper.INSTANCE;

    @Test
    public void roundHistoryToRoundHistoryDTO() {
        RoundHistory roundHistory = RoundHistory.builder()
                .player1Wins(0)
                .player2Wins(1)
                .totalDraws(2)
                .roundsPlayed(3)
                .build();

        RoundHistoryDTO roundHistoryDTO = roundHistoryMapper.roundHistoryToRoundHistoryDTO(roundHistory);

        assertEquals(roundHistory.getPlayer1Wins(), roundHistoryDTO.getPlayer1Wins());
        assertEquals(roundHistory.getPlayer2Wins(), roundHistoryDTO.getPlayer2Wins());
        assertEquals(roundHistory.getTotalDraws(), roundHistoryDTO.getTotalDraws());
        assertEquals(roundHistory.getRoundsPlayed(), roundHistoryDTO.getRoundsPlayed());
    }
}
