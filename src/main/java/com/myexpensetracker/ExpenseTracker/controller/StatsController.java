package com.myexpensetracker.ExpenseTracker.controller;

import com.myexpensetracker.ExpenseTracker.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StatsController {

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats")
    public String getStats(Model model) {
        try {
            model.addAttribute("lowestCost", statsService.findMinimumCost());
            model.addAttribute("highestCost", statsService.findHighestCost());
            model.addAttribute("averageCost", statsService.findAverageCost());
            return "stats";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}
