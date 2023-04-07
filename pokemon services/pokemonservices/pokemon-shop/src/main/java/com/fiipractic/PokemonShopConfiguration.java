package com.fiipractic;

import com.fiipractic.model.AppUser;
import com.fiipractic.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PokemonShopConfiguration implements CommandLineRunner {
    private final UserRepository userRepository;

    public PokemonShopConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        AppUser user1 = new AppUser("andreea", 1000);
//        AppUser user2 = new AppUser( "linux", 1900);
//        AppUser user3 = new AppUser("persi", 500);
//        AppUser user4 = new AppUser( "pisic", 700);
//        AppUser user5 = new AppUser( "test", 500);
//        AppUser user6 = new AppUser("cartofel", 70);
//        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6));
    }
}
