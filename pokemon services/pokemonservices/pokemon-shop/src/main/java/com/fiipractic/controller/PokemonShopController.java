package com.fiipractic.controller;

import com.fiipractic.model.BuyPokemonForm;
import com.fiipractic.model.Pokemon;
import com.fiipractic.model.AppUser;
import com.fiipractic.service.PokemonShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PokemonShopController {

    private final PokemonShopService pokemonShopService;

    public PokemonShopController(PokemonShopService pokemonShopService) {
        this.pokemonShopService = pokemonShopService;
    }

    @GetMapping(value="/shop")
    public String getApp(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "pokemon-shop-home";
    }

    @GetMapping(value="/registerpage")
    public String register(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "register-page";
    }

    @PostMapping(value="/register")
    public String register(@ModelAttribute AppUser appUser, Model model) {
        System.out.println(appUser);
        pokemonShopService.saveUser(appUser);
        model.addAttribute("appUser", new AppUser());
        return "pokemon-shop-home";
    }

    @PostMapping(value="/buy")
    public String buyPokemon(@ModelAttribute BuyPokemonForm buyPokemon, Model model) {
        try {
            AppUser customer = pokemonShopService.getUserByUsername(buyPokemon.getCustomerUsername());
            Pokemon pokemon = pokemonShopService.getPokemon(buyPokemon.getPokemonName());
            model.addAttribute("customer", customer.getUsername());
            model.addAttribute("pokemon", pokemon.getName());
            pokemonShopService.buyPokemon(customer, pokemon);
            model.addAttribute("money", customer.getMoney());
            return "pokemon-shop-bought";
        } catch (Exception e) {
            model.addAttribute("alert", "User doesn't exist");
            return "error";
        }
    }

    @PostMapping(value="/shop/pokemons")
    public String getUser(@ModelAttribute AppUser appUser, Model model) {
        model.addAttribute("buyPokemon", new BuyPokemonForm());
        try {
            AppUser user = pokemonShopService.getUserByUsername(appUser.getUsername());
            model.addAttribute("money", user.getMoney());
            model.addAttribute("username", user.getUsername());
            List<Pokemon> pokemons = pokemonShopService.getPokemons(3);
            model.addAttribute("pokemons", pokemons);
            return "pokemon-shop-buy";
        } catch (Exception e) {
            model.addAttribute("alert", "User doesn't exist");
            return "error";
        }
    }
}
