package com.gmail.serhiiromanchuk.composition.domain.usecases

import com.gmail.serhiiromanchuk.composition.domain.entity.GameSettings
import com.gmail.serhiiromanchuk.composition.domain.entity.Level
import com.gmail.serhiiromanchuk.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}