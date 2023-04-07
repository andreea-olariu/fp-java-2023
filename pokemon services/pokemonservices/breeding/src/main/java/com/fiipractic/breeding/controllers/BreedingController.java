package com.fiipractic.breeding.controllers;

import com.fiipractic.breeding.services.BreedingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BreedingController {
    private final BreedingService breedingService;

    public BreedingController(BreedingService breedingService) {
        this.breedingService = breedingService;
    }

    @GetMapping(value = "/breed")
    public String breed(@RequestParam(value="pokeId1") Integer pokeId1, @RequestParam(value="pokeId2") Integer pokeId2, Model model) {
        breedingService.breed(pokeId1, pokeId2, model);
        return "breeding";
    }
}
