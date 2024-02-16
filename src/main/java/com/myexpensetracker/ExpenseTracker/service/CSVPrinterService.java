package com.myexpensetracker.ExpenseTracker.service;
import com.myexpensetracker.ExpenseTracker.model.Expense;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVPrinterService {
    private ExpenseRepository expenseRepository;
    public CSVPrinterService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public CSVPrinterService(){

    }

    public void printToCSV(ExpenseRepository expenseRepository){
        StatsService statsService = new StatsService();
        List<Expense> expenseList = expenseRepository.findAll();
        try(CSVPrinter csvPrinter = new CSVPrinter(new FileWriter("csv.txt"), CSVFormat.EXCEL)){
            csvPrinter.printRecord("ID", "Price", "Description");
            for(Expense expense: expenseList){
                csvPrinter.printRecord(expense.getId(), expense.getPrice(), expense.getDescription());
            }
            csvPrinter.printRecord("Minimum cost", "Highest cost", "Average Cost");
            csvPrinter.printRecord(statsService.findMinimumCost(),statsService.findHighestCost(),statsService.findAverageCost());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
