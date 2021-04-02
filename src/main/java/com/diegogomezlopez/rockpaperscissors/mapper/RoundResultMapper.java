package com.diegogomezlopez.rockpaperscissors.mapper;

import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.dto.RoundResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoundResultMapper {

    RoundResultMapper INSTANCE = Mappers.getMapper(RoundResultMapper.class);

    @Mappings({
            @Mapping(source = "player1Move.move", target = "player1Move"),
            @Mapping(source = "player2Move.move", target = "player2Move"),
            @Mapping(source = "result.result", target = "result")
    })
    RoundResultDTO roundResultToRoundResultDTO(final RoundResult roundResult);
}
