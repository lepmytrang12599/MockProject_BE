package org.example.bookingbe.controller;

import org.example.bookingbe.dto.RevenueStatsDTO;
import org.example.bookingbe.service.StatisticsService.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin("*")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public RevenueStatsDTO getStatistics(@RequestParam String time) {
        return statisticsService.getRevenueStats(time);
    }
}
