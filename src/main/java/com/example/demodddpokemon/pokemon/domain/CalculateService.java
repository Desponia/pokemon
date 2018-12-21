package com.example.demodddpokemon.pokemon.domain;

import com.example.demodddpokemon.pokeball.domain.Pokeball;
import com.example.demodddpokemon.trainer.domain.Trainer;

public class CalculateService {

    // 포획률 = (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
    public double calculateCaptureRate(final Trainer trainer, final Pokemon pokemon, final Pokeball pokeball) {
        double calculatedCaptureRate = (pokemon.getCaptureRate() * pokeball.getBonusMultiplier() * trainer.getTrainerBonus()) * 100 / 255;
        if(calculatedCaptureRate < 100) {
            return calculatedCaptureRate;
        }
        return 100.0;
    }
}
