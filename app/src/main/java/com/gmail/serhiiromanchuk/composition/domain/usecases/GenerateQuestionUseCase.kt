package com.gmail.serhiiromanchuk.composition.domain.usecases

import com.gmail.serhiiromanchuk.composition.domain.entity.Question
import com.gmail.serhiiromanchuk.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(
            maxSumValue = maxSumValue,
            countOfOptions = COUNT_OF_OPTIONS
        )
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}