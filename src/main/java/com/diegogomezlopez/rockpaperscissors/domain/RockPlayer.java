package com.diegogomezlopez.rockpaperscissors.domain;

import lombok.Builder;

@Builder
public class RockPlayer extends Player {

    @Override
    public Move play() {
        return Move.ROCK;
    }
}
