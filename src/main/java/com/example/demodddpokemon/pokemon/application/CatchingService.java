package com.example.demodddpokemon.pokemon.application;

import com.example.demodddpokemon.pokeball.domain.Pokeball;
import com.example.demodddpokemon.pokeball.domain.PokeballRepository;
import com.example.demodddpokemon.pokemon.domain.CalculateService;
import com.example.demodddpokemon.pokemon.domain.Pokemon;
import com.example.demodddpokemon.pokemon.domain.PokemonRepository;
import com.example.demodddpokemon.trainer.domain.PokemonCaught;
import com.example.demodddpokemon.trainer.domain.Trainer;
import com.example.demodddpokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CatchingService {

    private TrainerRepository trainerRepository;
    private PokeballRepository pokeballRepository;
//    @Autowired
    private PokemonRepository pokemonRepository;

    public CatchingService(TrainerRepository trainerRepository, PokeballRepository pokeballRepository, PokemonRepository pokemonRepository) {
        this.trainerRepository = trainerRepository;
        this.pokeballRepository = pokeballRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public void tryCatching(final String trainerId, final int pokemonNumber, final int pokeBallId) {
        final Trainer trainer = trainerRepository.findById(trainerId);
        final Pokemon pokemon = pokemonRepository.findByNumber(pokemonNumber);
        final Pokeball pokeball = pokeballRepository.findById(pokeBallId).orElse(null);

        final CalculateService calculateService = new CalculateService();
        double calculateCaptureRate = calculateService.calculateCaptureRate(trainer, pokemon, pokeball);
        final boolean isCaught = pokemon.isCaught(calculateCaptureRate, new Random().nextInt(99) + 1);

        if(isCaught) {
            trainer.getPokemon(new PokemonCaught(pokemon.getNumber(), pokemon.getName()));
        }


    }

}

