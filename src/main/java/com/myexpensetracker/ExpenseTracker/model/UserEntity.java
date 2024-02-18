package com.myexpensetracker.ExpenseTracker.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Id
    @Column(name = "ID")
    private Long id;

}
