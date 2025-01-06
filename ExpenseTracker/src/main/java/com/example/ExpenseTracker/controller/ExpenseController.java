package com.example.ExpenseTracker.controller;

import com.example.ExpenseTracker.Service.ExpenseService;
import com.example.ExpenseTracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
    @PostMapping("/expense")
    public String addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return "expense added";
    }
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable int id){
        expenseService.deleteExpense(id);
        return "expense deleted";
    }
}
