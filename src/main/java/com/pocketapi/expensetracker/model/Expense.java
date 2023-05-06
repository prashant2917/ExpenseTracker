package com.pocketapi.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_expense",
      schema = "ecommerce"
)
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    @NotEmpty(message = "Expense name should not be Empty")
    private  String expenseName;

    @Column
    @Min(value = 1)
    private long expenseAmount;

    @Column
    @NotEmpty(message = "Mode cannot be Empty")
    private String expenseMode;

    @Column
    @NotEmpty(message = "Expense category cannot be empty")
    private String expenseCategory;

    @Column(name="created_at")
    private LocalDateTime expenseCreationDateTime = LocalDateTime.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public long getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(long expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseMode() {
        return expenseMode;
    }

    public void setExpenseMode(String expenseMode) {
        this.expenseMode = expenseMode;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public LocalDateTime getExpenseCreationDateTime() {

        return expenseCreationDateTime;
    }

    public void setExpenseCreationDateTime(LocalDateTime expenseCreationDateTime) {
        this.expenseCreationDateTime = expenseCreationDateTime;
    }
}
