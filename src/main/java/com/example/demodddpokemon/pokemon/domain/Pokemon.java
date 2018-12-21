package com.example.demodddpokemon.pokemon.domain;

//pokemon entity
public class Pokemon {
    // entity의 식별자
    private int number;
    private String name;
    //    pokemon image
    private String sprites;
    private int captureRate;

    public Pokemon(int number, String name, String sprites, int captureRate) {
        this.number = number;
        this.name = name;
        this.sprites = sprites;
        this.captureRate = captureRate;
    }

    public boolean isCaught(final double calculatedCaptureRate) {
        return number <= calculatedCaptureRate;
    }
}
