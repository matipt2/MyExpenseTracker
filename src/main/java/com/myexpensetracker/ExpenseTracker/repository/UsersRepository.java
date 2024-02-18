package com.myexpensetracker.ExpenseTracker.repository;

import com.myexpensetracker.ExpenseTracker.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {}
