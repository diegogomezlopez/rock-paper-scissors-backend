package com.diegogomezlopez.rockpaperscissors.mapper;

import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.dto.RoundResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoundResultMapper {

    RoundResultMapper INSTANCE = Mappers.getMapper(RoundResultMapper.class);

    RoundResultDTO roundResultToRoundResultDTO(final RoundResult roundResult);
}
