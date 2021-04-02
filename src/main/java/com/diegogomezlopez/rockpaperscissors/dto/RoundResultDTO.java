package com.diegogomezlopez.rockpaperscissors.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoundResultDTO {

    private String player1Move;
    private String player2Move;
    private String result;

    public RoundResultDTO(final String player1Move, final String player2Move, final String result) {
        this.player1Move = player1Move;
        this.player2Move = player2Move;
        this.result = result;
    }
}
