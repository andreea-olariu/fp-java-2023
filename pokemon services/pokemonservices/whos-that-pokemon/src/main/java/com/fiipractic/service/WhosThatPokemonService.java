package com.fiipractic.service;
import com.fiipractic.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WhosThatPokemonService {
    public Pokemon getRandomPokemon() {
        RestTemplate restTemplate = new RestTemplate();
        Pokemon[] response = restTemplate.getForObject(
                "http://localhost:8081/pokedex/random?limit=1",
                Pokemon[].class);

        return response[0];
    }

    public Pokemon getPokemonById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Pokemon pokemon = restTemplate.getForObject(
                "http://localhost:8081/pokedex/pokemon/" + id,
                Pokemon.class);
        return pokemon;
    }

}
