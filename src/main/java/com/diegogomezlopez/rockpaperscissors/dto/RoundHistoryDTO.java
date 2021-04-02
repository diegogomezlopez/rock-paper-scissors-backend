package com.diegogomezlopez.rockpaperscissors.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoundHistoryDTO {

    private Integer player1Wins;
    private Integer player2Wins;
    private Integer totalDraws;
    private Integer roundsPlayed;
}
