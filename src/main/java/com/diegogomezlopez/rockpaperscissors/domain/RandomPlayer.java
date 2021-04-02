package com.diegogomezlopez.rockpaperscissors.domain;

import lombok.Builder;

import java.util.Random;

@Builder
public class RandomPlayer extends Player {

    @Override
    public Move play() {
        return Move.values()[new Random().nextInt(Move.values().length)];
    }
}
