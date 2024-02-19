package com.myexpensetracker.ExpenseTracker.controller;
import com.myexpensetracker.ExpenseTracker.model.Expense;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import com.myexpensetracker.ExpenseTracker.service.ExpenseFilterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Comparator;
import java.util.List;

@Controller
public class ExpenseFilterController {
    private final ExpenseRepository expenseRepository;

    public ExpenseFilterController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/filterByMinimum")
    public String filterExpenseByMin(Model model){
        ExpenseFilterService expenseFilterService = new ExpenseFilterService(expenseRepository);
        List<Expense> filteredExpenses = expenseFilterService.filterByMinimum();
        filteredExpenses.sort(Comparator.comparing(Expense::getPrice));
        model.addAttribute("expenses", filteredExpenses);
        model.addAttribute("newExpense", new Expense());
        return "expense";
    }

    @GetMapping("/filterByMaximum")
    public String filterExpenseByMax(Model model){
        ExpenseFilterService expenseFilterService = new ExpenseFilterService(expenseRepository);
        List<Expense> filteredExpenses = expenseFilterService.filterByMaximum();
        filteredExpenses.sort(Comparator.comparing(Expense::getPrice).reversed());
        model.addAttribute("expenses", filteredExpenses);
        model.addAttribute("newExpense", new Expense());
        return "expense";
    }
}
