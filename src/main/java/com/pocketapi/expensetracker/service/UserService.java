package com.pocketapi.expensetracker.service;

import com.pocketapi.expensetracker.model.User;
import com.pocketapi.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  @Autowired
    UserRepository userRepository;

   public List<User> getAllUsers() {
       List<User> userList = new ArrayList<>();
     userRepository.findAll().forEach(userList::add);
     return userList;
   }

   public void addUser(User user) {
       userRepository.save(user);
   }
}
