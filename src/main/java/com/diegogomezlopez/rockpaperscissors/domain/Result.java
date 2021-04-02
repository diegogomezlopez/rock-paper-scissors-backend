package com.diegogomezlopez.rockpaperscissors.domain;

public enum Result {

    WIN("Win"), LOSE("Lose"), DRAW("Draw");

    private final String result;

    Result(final String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
