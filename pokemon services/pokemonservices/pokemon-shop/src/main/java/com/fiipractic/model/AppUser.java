package com.fiipractic.model;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class AppUser {
    @Id
    private Integer id;
    private String username;
    private Integer money;

    public AppUser(Integer id, String username, Integer money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }
    public AppUser(String username, Integer money) {
        this.username = username;
        this.money = money;
    }

    public AppUser(String username) {
        this.username = username;
        this.money = 500;
    }

    public AppUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
