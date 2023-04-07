package com.fiipractic.service;

import com.fiipractic.model.AppUser;
import com.fiipractic.model.Pokedex;
import com.fiipractic.model.Pokemon;
import com.fiipractic.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.List;

@Service
public class PokemonShopService {

    private final UserRepository userRepository;

    public PokemonShopService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Pokemon> getPokemons(Integer nr) {
        RestTemplate restTemplate = new RestTemplate();
        Pokemon[] pokemons = restTemplate.getForObject(
                "http://localhost:8081/pokedex/random?limit=" + nr,
                Pokemon[].class);
        return List.of(pokemons);
    }

    public AppUser getUserByUsername(String username) throws SQLException {
        AppUser user = userRepository.findAppUserByUsername(username);
        if(user == null) {
            throw new SQLException();
        }
        return user;
    }

    public void buyPokemon(AppUser customer, Pokemon pokemon) throws Exception {
        if(customer.getMoney() < (pokemon.getBaseTotal() / 10)) {
            throw new Exception();
        }
        customer.setMoney(customer.getMoney() - (pokemon.getBaseTotal() / 10));
        userRepository.save(customer);
    }

    public Pokemon getPokemon(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Pokedex[] pokemons = restTemplate.getForObject(
                "http://localhost:8081/pokedex?search=" + name.toLowerCase(),
                Pokedex[].class);
        Pokedex pokemon = pokemons[0];
        return new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getBaseTotal(), pokemon.getBaseEggSteps());
    }
}
