package com.diegogomezlopez.rockpaperscissors.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomPlayerTest {

    @Test
    public void play_whenPlay_thenReturnRandomMove() {
        RandomPlayer randomPlayer = RandomPlayer.builder().build();

        Move move = randomPlayer.play();

        assertTrue(Arrays.asList(Move.values()).contains(move));
    }
}
