package com.fiipractic.battle.services;

import com.fiipractic.pokemoncatalog.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BattleService {
    public String battle(Model model) {
        List<Pokemon> team1 = this.getTeam(10);
        List<Pokemon> team2 = this.getTeam(10);

        String result;
        if(getTeamPower(team1) == getTeamPower(team2)) {
            result = "Echipele sunt la egalitate!";
        }
        else {
            result = getTeamPower(team1) > getTeamPower(team2) ? "Echipa 1 castiga" : "Echipa 2 castiga";
        }

        model.addAttribute("team1", team1);
        model.addAttribute("team2", team2);
        model.addAttribute("result", result);
        return result;
    }
    public Integer getTeamPower(List<Pokemon> list) {
        Integer sum = 0;
        for(Pokemon pokemon : list)
            sum += pokemon.getBaseTotal();
        return sum;
    }

    private List<Pokemon> getTeam(Integer teamSize) {
        RestTemplate restTemplate = new RestTemplate();
        Pokemon[] response = restTemplate.getForObject(
                "http://localhost:8081/pokedex/random?limit=" + teamSize,
                Pokemon[].class);

        List<Pokemon> team = Arrays.stream(response).toList();
        return team;
    }
}
