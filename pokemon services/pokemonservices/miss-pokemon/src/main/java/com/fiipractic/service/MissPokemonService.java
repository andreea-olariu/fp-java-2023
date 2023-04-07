package com.fiipractic.service;

import com.fiipractic.pokemoncatalog.model.Pokedex;
import com.fiipractic.pokemoncatalog.model.Pokemon;
import com.fiipractic.pokemoncatalog.repository.PokemonCatalogRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MissPokemonService {
    private final PokemonCatalogRepository pokemonCatalogRepository;

    public MissPokemonService(PokemonCatalogRepository pokemonCatalogRepository) {
        this.pokemonCatalogRepository = pokemonCatalogRepository;
    }

    public List<Pokemon> getPokemons(Integer nr) {
        RestTemplate restTemplate = new RestTemplate();
        Pokemon[] pokemons = restTemplate.getForObject(
                "http://localhost:8081/pokedex/random?limit=" + nr,
                Pokemon[].class);
        return List.of(pokemons);
    }

    public Pokedex getPokemon(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Pokedex[] pokemons = restTemplate.getForObject(
                "http://localhost:8081/pokedex?search=" + name.toLowerCase(),
                Pokedex[].class);
        Pokedex pokemon = pokemons[0];
        return pokemon;
    }

    public void increase(String name) {
        Pokedex pokemon = getPokemon(name);
        pokemon.setBaseTotal(pokemon.getBaseTotal() + 10);
        pokemonCatalogRepository.save(pokemon);
    }
}
