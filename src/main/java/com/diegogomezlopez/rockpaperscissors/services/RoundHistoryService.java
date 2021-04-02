package com.diegogomezlopez.rockpaperscissors.services;

import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;

public interface RoundHistoryService extends CrudRepository<RoundHistory> {

    RoundHistory update(final RoundResult roundResult);
}
