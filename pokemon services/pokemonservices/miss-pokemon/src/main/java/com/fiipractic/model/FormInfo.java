package com.fiipractic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FormInfo {
    public String pokemonName;
    @Id
    private Long id;

    public FormInfo() {
    }

    public FormInfo(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    @Override
    public String toString() {
        return "FormInfo{" +
                "pokemonName='" + pokemonName + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
