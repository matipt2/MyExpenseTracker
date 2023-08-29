package com.myexpensetracker.ExpenseTracker.controller;

import com.myexpensetracker.ExpenseTracker.model.Expense;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ExpenseController {
    private final ExpenseRepository expenseRepository;
    private List<Expense> expenses;
    @Autowired
    public ExpenseController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;



    }
    @GetMapping("/expense")
    public String getExpense(Model model){
        List<Expense> expenses = expenseRepository.findAll();

        model.addAttribute("expenses", expenseRepository.findAll());
        model.addAttribute("newExpense", new Expense());
        return "expense";
    }

    @PostMapping("/add-expense")
    public String addExpense(@ModelAttribute Expense expense){

        expenseRepository.save(expense);
        return "redirect:/expense";
    }
}
