package com.myexpensetracker.ExpenseTracker.controller;

import com.myexpensetracker.ExpenseTracker.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller

public class ExpenseController {
    private List<Expense> expenses;
    public ExpenseController(){

        expenses = new ArrayList<>();

    }
    @GetMapping("/expense")
    public String getExpense(Model model){
        model.addAttribute("expenses", expenses);
        model.addAttribute("newExpense", new Expense());
        return "expense";
    }

    @PostMapping("/add-expense")
    public String addExpense(@ModelAttribute Expense expense){
        expenses.add(expense);
        return "redirect:/expense";
    }
}
