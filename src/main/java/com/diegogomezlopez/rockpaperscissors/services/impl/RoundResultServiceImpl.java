package com.diegogomezlopez.rockpaperscissors.services.impl;

import com.diegogomezlopez.rockpaperscissors.domain.Move;
import com.diegogomezlopez.rockpaperscissors.domain.Result;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.services.RoundResultService;
import org.springframework.stereotype.Service;

@Service
public class RoundResultServiceImpl extends AbstractCrudRepository<RoundResult> implements RoundResultService {

    @Override
    public RoundResult getRoundResult(final Move player1Move, final Move player2Move) {

        Result result;

        if (player1Move == player2Move) {
            result = Result.DRAW;
        } else if (player1Move.defeat(player2Move)) {
            result = Result.WIN;
        } else {
            result = Result.LOSE;
        }

        return RoundResult.builder()
                .player1Move(player1Move)
                .player2Move(player2Move)
                .result(result)
                .build();
    }
}
