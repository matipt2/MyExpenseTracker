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
        Expense expense1 = new Expense("opis", new BigDecimal("1.50"));
        Expense expense2 = new Expense("oddd", new BigDecimal("6.27"));
        Expense expense3 = new Expense("fdfis", new BigDecimal("542.2"));
        Expense expense4 = new Expense("ocxzcxs", new BigDecimal("23.4"));
        expenses = new ArrayList<>();
        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);
        expenses.add(expense4);

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
