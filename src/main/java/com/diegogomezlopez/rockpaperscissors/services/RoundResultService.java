package com.diegogomezlopez.rockpaperscissors.services;

import com.diegogomezlopez.rockpaperscissors.domain.Move;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;

public interface RoundResultService extends CrudRepository<RoundResult> {

    RoundResult getRoundResult(final Move player1Move, final Move player2Move);
}
