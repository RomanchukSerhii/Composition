package com.gmail.serhiiromanchuk.composition.domain.repository

import com.gmail.serhiiromanchuk.composition.domain.entity.GameSettings
import com.gmail.serhiiromanchuk.composition.domain.entity.Level
import com.gmail.serhiiromanchuk.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Level): GameSettings
}