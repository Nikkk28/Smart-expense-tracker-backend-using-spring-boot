package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public void addExpense(Expense expense){
        expenseRepository.save(expense);

    }
    public void deleteExpense(int id){
        if(expenseRepository.existsById(id)){
            expenseRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Expense by id: "+id+" does not exist");
        }

    }
}
