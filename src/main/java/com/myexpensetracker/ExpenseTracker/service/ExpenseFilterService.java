package com.myexpensetracker.ExpenseTracker.service;
import com.myexpensetracker.ExpenseTracker.model.Expense;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseFilterService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseFilterService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public List<Expense> filterByMinimum() {
        List<Expense> expenseList = expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getPrice))
                .collect(Collectors.toList());
        return expenseList;

    }
    public List<Expense> filterByMaximum() {
        List<Expense> expenseList = expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getPrice).reversed())
                .collect(Collectors.toList());
        return expenseList;
    }
}
