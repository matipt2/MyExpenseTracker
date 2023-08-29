package com.myexpensetracker.ExpenseTracker;

import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class DbInit implements CommandLineRunner {
    private final ExpenseRepository expenseRepository;
    @Autowired
    public DbInit(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        expenseRepository.saveAll(List.of());
    }
}
