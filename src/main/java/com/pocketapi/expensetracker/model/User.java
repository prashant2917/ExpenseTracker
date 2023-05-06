package com.pocketapi.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_users",
        schema = "ecommerce"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    @NotEmpty(message = "Name should not be Empty")
    private  String name;

    @Column
    @Email(message = "Enter a Valid Email Id")
    @NotEmpty(message = "Email id should not be Empty")
    private String emailId;

    @Column
    @NotEmpty(message = "Enter a Valid Password")
    @Size(min = 6,max = 15,message = "Password length should be at least 6 and max 15 characters")
    private String password;


    @Column(name="register_at")
    private LocalDateTime userCreationDateTime = LocalDateTime.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDateTime getUserCreationDateTime() {
        return userCreationDateTime;
    }

    public void setUserCreationDateTime(LocalDateTime userCreationDateTime) {
        this.userCreationDateTime = userCreationDateTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
