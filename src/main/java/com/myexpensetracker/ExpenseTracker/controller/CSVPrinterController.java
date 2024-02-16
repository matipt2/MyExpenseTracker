package com.myexpensetracker.ExpenseTracker.controller;
import com.myexpensetracker.ExpenseTracker.model.Expense;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import com.myexpensetracker.ExpenseTracker.service.CSVPrinterService;
import com.myexpensetracker.ExpenseTracker.service.StatsService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
public class CSVPrinterController extends StatsService{
    private final ExpenseRepository expenseRepository;
    public CSVPrinterController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/saveToCSV")
    public String saveDataToCSV(){
        CSVPrinterService csvPrinterService = new CSVPrinterService();
        if(expenseRepository.count()>0){
            csvPrinterService.printToCSV(expenseRepository);
        }
        else{
            throw new IllegalArgumentException("database is null");
        }
        return "/saveToCSV";
    }
}