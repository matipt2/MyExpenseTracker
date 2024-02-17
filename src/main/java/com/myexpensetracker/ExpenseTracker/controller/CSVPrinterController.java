package com.myexpensetracker.ExpenseTracker.controller;
import com.myexpensetracker.ExpenseTracker.repository.ExpenseRepository;
import com.myexpensetracker.ExpenseTracker.service.CSVPrinterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CSVPrinterController{
    private final ExpenseRepository expenseRepository;
    public CSVPrinterController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/saveToCSV")
    public String saveDataToCSV(){
        CSVPrinterService csvPrinterService = new CSVPrinterService();
        if(expenseRepository.count()>0){
            csvPrinterService.printToCSV(expenseRepository);
            return "saveToCSV";
        }
        else{
            throw new IllegalArgumentException("database is null");
        }
    }
}