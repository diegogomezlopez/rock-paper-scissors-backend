package com.diegogomezlopez.rockpaperscissors.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoundHistory {

    private Integer player1Wins;
    private Integer player2Wins;
    private Integer totalDraws;
    private Integer roundsPlayed;
}
