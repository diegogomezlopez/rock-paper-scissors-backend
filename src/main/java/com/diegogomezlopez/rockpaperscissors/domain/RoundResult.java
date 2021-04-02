package com.diegogomezlopez.rockpaperscissors.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoundResult {

    private Move player1Move;
    private Move player2Move;
    private Result result;

    public RoundResult(final Move player1Move, final Move player2Move, final Result result) {
        this.player1Move = player1Move;
        this.player2Move = player2Move;
        this.result = result;
    }
}
