package com.pocketapi.expensetracker.controller;

import com.pocketapi.expensetracker.model.Message;
import com.pocketapi.expensetracker.model.User;
import com.pocketapi.expensetracker.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-api")
public class UserController {
@Autowired
    UserService userService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping(value = "/add-user")
   public ResponseEntity addUser(@Valid @RequestBody User user ) {
        userService.addUser(user);
        logger.info("Add User");
        Message message = new Message();
        message.setMessage("User " + user.getName() + "  Register Successfully");

        return new ResponseEntity(message, HttpStatus.CREATED);
    }

}
