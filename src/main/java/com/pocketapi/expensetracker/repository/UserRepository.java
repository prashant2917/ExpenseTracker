package com.pocketapi.expensetracker.repository;

import com.pocketapi.expensetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
