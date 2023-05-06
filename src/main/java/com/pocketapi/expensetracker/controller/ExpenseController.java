package com.pocketapi.expensetracker.controller;

import com.pocketapi.expensetracker.model.Expense;
import com.pocketapi.expensetracker.model.Message;
import com.pocketapi.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/expense-api")
public class ExpenseController {
@Autowired
    ExpenseService expenseService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
@GetMapping(value = "/expenses")
public ResponseEntity getAllExpenses() {
    List<Expense> expenseList = expenseService.getAllExpenses();
   if(expenseList.isEmpty()) {
       Message message = new Message();
       message.setMessage("No expenses found");
       return new ResponseEntity(message, HttpStatus.NOT_FOUND);
   }
   else {
       return  new ResponseEntity(expenseList, HttpStatus.OK);
   }
}

    @PostMapping(value = "/add-expense")
    public ResponseEntity addExpense(@Valid @RequestBody Expense expense) {
        expenseService.AddExpense(expense);
        logger.info("Add expense");
        Message message = new Message();
        message.setMessage("Expense " + expense.getExpenseName() + "  Added Successfully");

        return new ResponseEntity(message, HttpStatus.CREATED);
    }

}
