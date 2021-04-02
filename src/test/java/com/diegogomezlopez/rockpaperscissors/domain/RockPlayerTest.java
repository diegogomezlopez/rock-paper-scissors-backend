package com.diegogomezlopez.rockpaperscissors.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPlayerTest {

    @Test
    public void play_whenPlay_thenReturnRock() {
        RockPlayer rockPlayer = RockPlayer.builder().build();

        Move move = rockPlayer.play();

        assertEquals(move, Move.ROCK);
    }
}
