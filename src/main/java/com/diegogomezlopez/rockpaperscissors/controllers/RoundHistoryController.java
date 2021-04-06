package com.diegogomezlopez.rockpaperscissors.controllers;

import com.diegogomezlopez.rockpaperscissors.domain.RoundHistory;
import com.diegogomezlopez.rockpaperscissors.dto.RoundHistoryDTO;
import com.diegogomezlopez.rockpaperscissors.mapper.RoundHistoryMapper;
import com.diegogomezlopez.rockpaperscissors.services.RoundHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(RoundHistoryController.BASE_URL)
public class RoundHistoryController {

    public static final String BASE_URL = "/api/v1/history";

    private final RoundHistoryMapper roundHistoryMapper;
    private final RoundHistoryService roundHistoryService;

    public RoundHistoryController(final RoundHistoryMapper roundHistoryMapper, final RoundHistoryService roundHistoryService) {
        this.roundHistoryMapper = roundHistoryMapper;
        this.roundHistoryService = roundHistoryService;
    }

    @GetMapping
    public ResponseEntity<RoundHistoryDTO> getRoundHistory() {
        RoundHistory roundHistory = roundHistoryService.find();
        return ResponseEntity.ok(roundHistoryMapper.roundHistoryToRoundHistoryDTO(roundHistory));
    }

}
