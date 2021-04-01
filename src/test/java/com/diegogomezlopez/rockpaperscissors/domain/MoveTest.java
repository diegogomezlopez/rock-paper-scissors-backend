package com.diegogomezlopez.rockpaperscissors.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {

    @Test
    public void defeat_whenRockVSPaper_thenReturnFalse() {
        Move rock = Move.ROCK;
        Move paper = Move.PAPER;

        boolean defeat = rock.defeat(paper);

        assertFalse(defeat);
    }

    @Test
    public void defeat_whenRockVSScissors_thenReturnTrue() {
        Move rock = Move.ROCK;
        Move scissors = Move.SCISSORS;

        boolean defeat = rock.defeat(scissors);

        assertTrue(defeat);
    }

    @Test
    public void defeat_whenRockVSRock_thenReturnFalse() {
        Move rock = Move.ROCK;
        Move opponentRock = Move.ROCK;

        boolean defeat = rock.defeat(opponentRock);

        assertFalse(defeat);
    }

    @Test
    public void defeat_whenPaperVSRock_thenReturnTrue() {
        Move paper = Move.PAPER;
        Move rock = Move.ROCK;

        boolean defeat = paper.defeat(rock);

        assertTrue(defeat);
    }

    @Test
    public void defeat_whenPaperVSScissors_thenReturnFalse() {
        Move paper = Move.PAPER;
        Move scissors = Move.SCISSORS;

        boolean defeat = paper.defeat(scissors);

        assertFalse(defeat);
    }

    @Test
    public void defeat_whenPaperVSPaper_thenReturnFalse() {
        Move paper = Move.PAPER;
        Move opponentPaper = Move.PAPER;

        boolean defeat = paper.defeat(opponentPaper);

        assertFalse(defeat);
    }

    @Test
    public void defeat_whenScissorsVSRock_thenReturnFalse() {
        Move scissors = Move.SCISSORS;
        Move rock = Move.ROCK;

        boolean defeat = scissors.defeat(rock);

        assertFalse(defeat);
    }

    @Test
    public void defeat_whenScissorsVSPaper_thenReturnTrue() {
        Move scissors = Move.SCISSORS;
        Move paper = Move.PAPER;

        boolean defeat = scissors.defeat(paper);

        assertTrue(defeat);
    }

    @Test
    public void defeat_whenScissorsVSScissors_thenReturnFalse() {
        Move scissors = Move.SCISSORS;
        Move opponentScissors = Move.SCISSORS;

        boolean defeat = scissors.defeat(opponentScissors);

        assertFalse(defeat);
    }
}
