package com.diegogomezlopez.rockpaperscissors.controllers;

import com.diegogomezlopez.rockpaperscissors.domain.RandomPlayer;
import com.diegogomezlopez.rockpaperscissors.domain.RockPlayer;
import com.diegogomezlopez.rockpaperscissors.domain.RoundResult;
import com.diegogomezlopez.rockpaperscissors.dto.RoundResultDTO;
import com.diegogomezlopez.rockpaperscissors.mapper.RoundResultMapper;
import com.diegogomezlopez.rockpaperscissors.services.RoundResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PlayRoundController.BASE_URL)
public class PlayRoundController {

    public static final String BASE_URL = "/api/v1/playround";

    private final RoundResultService roundResultService;
    private final RoundResultMapper roundResultMapper;

    public PlayRoundController(
            final RoundResultService roundResultService,
            final RoundResultMapper roundResultMapper
    ) {
        this.roundResultService = roundResultService;
        this.roundResultMapper = roundResultMapper;
    }

    @GetMapping
    public ResponseEntity<RoundResultDTO> playRound() {
        RoundResult roundResult = roundResultService.getRoundResult(
                RandomPlayer.builder().build().play(),
                RockPlayer.builder().build().play()
        );

        RoundResultDTO roundResultDTO = roundResultMapper.roundResultToRoundResultDTO(roundResult);

        return ResponseEntity.ok(roundResultDTO);
    }
}
