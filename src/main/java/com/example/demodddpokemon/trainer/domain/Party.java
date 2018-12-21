package com.example.demodddpokemon.trainer.domain;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

// 다른 entity에 속해있음을 jpa에 알리기 위한 annotation
@Embeddable
public class Party {

    // 아래 객체가 collections임을 jpa에 알리는 annotation
    @ElementCollection
    // collection type을 별도의 테이블로 따로 관리하겠다는 annotation, defaul name : embedded entity name _ 아래 변수명.--> TRAINER_POKEMONS
    @CollectionTable(name = "PARTY")
    private List<PokemonCaught> pokemons;

    public boolean isEmpty() {
        return (this.pokemons == null || pokemons.isEmpty());
    }

    public void add(final PokemonCaught pokemonCaught) {
        if(isEmpty()) {
            this.pokemons = new ArrayList<>();
        }
        this.pokemons.add(pokemonCaught);
    }
}
