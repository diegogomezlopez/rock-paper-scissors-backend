package com.diegogomezlopez.rockpaperscissors.startup;

import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.services.RoundHistoryService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final RoundHistoryService roundHistoryService;

    public AppStartupRunner(final RoundHistoryService roundHistoryService) {
        this.roundHistoryService = roundHistoryService;
    }

    @Override
    public void run(ApplicationArguments args) {
        roundHistoryService.save(RoundHistory.builder()
                .player1Wins(0)
                .player2Wins(0)
                .totalDraws(0)
                .roundsPlayed(0)
                .build());
    }

}
