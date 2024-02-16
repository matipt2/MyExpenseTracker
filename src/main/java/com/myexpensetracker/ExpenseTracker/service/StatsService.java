package com.myexpensetracker.ExpenseTracker.service;
import com.myexpensetracker.ExpenseTracker.model.Expense;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StatsService {
    private ExpenseRepository expenseRepository;

    @Autowired
    public StatsService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public StatsService(){
    }
    public BigDecimal findMinimumCost(){
        List<Expense> expenses = expenseRepository.findAll();

        if(expenses.isEmpty()){
            throw new IllegalArgumentException("there are no expenses");
        }
        BigDecimal minCost = expenses.get(0).getPrice();
        for(Expense expense: expenses){
            if(expense.getPrice().compareTo(minCost)<0){
                minCost = expense.getPrice();
            }
        }
        return minCost;
    }

    public BigDecimal findHighestCost(){
        List<Expense> expenses = expenseRepository.findAll();
        if(expenses.isEmpty()){
            throw new IllegalArgumentException("there are no expenses");
        }
        BigDecimal highestCost = expenses.get(0).getPrice();
        for(Expense expense: expenses){
            if(expense.getPrice().compareTo(highestCost)>0){
                highestCost = expense.getPrice();
            }
        }
        return highestCost;
    }

    public BigDecimal findAverageCost(){
        List<Expense> expenses = expenseRepository.findAll();
        if(expenses.isEmpty()){
            throw new IllegalArgumentException("there are no expenses");
        }
        BigDecimal sum = new BigDecimal(0.0);
        for(Expense expense: expenses){
            sum = sum.add(expense.getPrice());
        }
        BigDecimal average = new BigDecimal(String.valueOf(sum.divide(BigDecimal.valueOf(expenses.size()))));
        return average;
    }

}
