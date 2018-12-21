package com.example.demodddpokemon.trainer.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

// root entity
@Entity
public class Trainer {

    @Id
    private String id;
    private int level;

    private Trainer() {
    }

    @Embedded
    private Party party;

    public Trainer(String id) {
        this.id = id;
        this.level = 1;
        this.party = new Party();
    }

    public void levelUp() {
        if(this.level < 30)
            this.level++;
    }

    public void getPokemon(final PokemonCaught pokemonCaught) {
        this.party.add(pokemonCaught);
        levelUp();
    }

    public double getTrainerBonus() {
        if(this.level < 11)
            return 1.0;

        return this.level / 10.0;
    }

}
