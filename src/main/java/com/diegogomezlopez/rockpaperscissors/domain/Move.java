package com.diegogomezlopez.rockpaperscissors.domain;

public enum Move {

    ROCK("Rock"), PAPER("Paper"), SCISSORS("Scissors");

    private final String move;

    Move(final String move) {
        this.move = move;
    }

    public String getMove() {
        return this.move;
    }

    public boolean defeat(final Move opponentMove) {
        switch (this) {
            case ROCK:
                return opponentMove.equals(SCISSORS);
            case PAPER:
                return opponentMove.equals(ROCK);
            case SCISSORS:
                return opponentMove.equals(PAPER);
            default:
                throw new IllegalStateException("Invalid Move");
        }
    }
}
