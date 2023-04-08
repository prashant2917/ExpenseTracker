package com.pocketapi.expensetracker.service;

import com.pocketapi.expensetracker.model.Expense;
import com.pocketapi.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ExpenseService {
   @Autowired
    ExpenseRepository expenseRepository;

   public List<Expense> getAllExpenses() {
       List<Expense> expenseList = new ArrayList<>();
         expenseRepository.findAll().forEach(expenseList::add);
          return  expenseList;
   }

   public  void AddExpense(Expense expense) {
       expenseRepository.save(expense);
   }


}
