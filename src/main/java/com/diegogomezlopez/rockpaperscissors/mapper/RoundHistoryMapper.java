package com.diegogomezlopez.rockpaperscissors.mapper;

import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.dto.RoundHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoundHistoryMapper {

    RoundHistoryMapper INSTANCE = Mappers.getMapper(RoundHistoryMapper.class);

    RoundHistoryDTO roundHistoryToRoundHistoryDTO(final RoundHistory roundHistory);
}
