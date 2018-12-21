package com.example.demodddpokemon.pokeball.domain;

public class Pokeball {
    private int id;
    private String name;
    private double bonusMultiplier;

    public Pokeball(int id, String name, double bonusMultiplier) {
        this.id = id;
        this.name = name;
        this.bonusMultiplier = bonusMultiplier;
    }

    public double getBonusMultiplier() {
        return bonusMultiplier;
    }
}
