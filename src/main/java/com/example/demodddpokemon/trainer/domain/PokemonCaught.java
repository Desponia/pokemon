package com.example.demodddpokemon.trainer.domain;

public class PokemonCaught {
    private int number;
    private String nickName;

    public PokemonCaught(int number, String nickName) {
        this.number = number;
        this.nickName = nickName;
    }

    public void changeNickName(final String nickName) {
        this.nickName = nickName;
    }
}
