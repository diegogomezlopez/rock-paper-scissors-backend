package com.diegogomezlopez.rockpaperscissors.services.impl;

import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.services.RoundHistoryService;
import org.springframework.stereotype.Service;

@Service
public class RoundHistoryServiceImpl extends AbstractCrudRepository<RoundHistory> implements RoundHistoryService {

    @Override
    public RoundHistory update(RoundResult roundResult) {

        RoundHistory roundHistory = this.find();

        switch (roundResult.getResult()) {
            case WIN:
                roundHistory.setPlayer1Wins(roundHistory.getPlayer1Wins() + 1);
                break;
            case LOSE:
                roundHistory.setPlayer2Wins(roundHistory.getPlayer2Wins() + 1);
                break;
            case DRAW:
                roundHistory.setTotalDraws(roundHistory.getTotalDraws() + 1);
                break;
            default:
                throw new IllegalStateException("Invalid result state");
        }

        roundHistory.setRoundsPlayed(roundHistory.getRoundsPlayed() + 1);

        return this.save(roundHistory);
    }
}
