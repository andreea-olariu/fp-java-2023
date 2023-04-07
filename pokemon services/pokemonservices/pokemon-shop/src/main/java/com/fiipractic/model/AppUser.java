package com.fiipractic.model;
import jakarta.persistence.*;

import java.util.Random;
import java.util.UUID;

@Entity
@Table(name="users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private Integer money;

    public AppUser(String username, Integer money) {
        this.username = username;
        this.money = money;
    }

    public AppUser(String username) {
        this.username = username;
    }

    public AppUser() {
        Random random = new Random();
        this.money = random.nextInt(0, 501);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}
