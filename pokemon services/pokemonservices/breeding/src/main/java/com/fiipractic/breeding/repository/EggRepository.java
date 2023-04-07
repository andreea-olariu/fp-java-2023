package com.fiipractic.breeding.repository;

import com.fiipractic.breeding.models.Egg;
import com.fiipractic.breeding.models.EggStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EggRepository extends JpaRepository<Egg, Integer> {
    public Egg findOneByPokemon1AndPokemon2AndStatus(Integer pokemon1, Integer pokemon2, EggStatus status);
    public List<Egg> findByStatus(EggStatus status);
}
