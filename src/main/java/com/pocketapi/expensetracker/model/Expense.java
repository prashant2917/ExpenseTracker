package com.pocketapi.expensetracker.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    Date creationDateTime;
}
