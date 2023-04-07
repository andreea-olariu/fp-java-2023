package com.fiipractic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuyPokemonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerUsername;
    private String pokemonName;

    public BuyPokemonForm() {
    }

    public BuyPokemonForm(String customerUsername, String pokemonName) {
        this.customerUsername = customerUsername;
        this.pokemonName = pokemonName;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    @Override
    public String toString() {
        return "BuyPokemonForm{" +
                "customerUsername='" + customerUsername + '\'' +
                ", pokemonName='" + pokemonName + '\'' +
                '}';
    }
}
