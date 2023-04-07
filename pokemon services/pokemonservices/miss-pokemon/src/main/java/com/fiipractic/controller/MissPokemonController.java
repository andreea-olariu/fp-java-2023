package com.fiipractic.controller;

import com.fiipractic.model.FormInfo;
import com.fiipractic.pokemoncatalog.model.Pokemon;
import com.fiipractic.service.MissPokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MissPokemonController {

    private final MissPokemonService missPokemonService;

    public MissPokemonController(MissPokemonService missPokemonService) {
        this.missPokemonService = missPokemonService;
    }


    @GetMapping(value = "/miss")
    public String getMiss(Model model) {
        List<Pokemon> pokemons = missPokemonService.getPokemons(5);
        model.addAttribute("pokemons", pokemons);

        return "miss-pokemon";
    }

    @PostMapping(value = "/miss/winner")
    public String getMiss(@ModelAttribute FormInfo form, Model model) {
        missPokemonService.increase(form.pokemonName);
        model.addAttribute("pokemon", form.getPokemonName());
        return "miss-pokemon-winner";
    }
}
