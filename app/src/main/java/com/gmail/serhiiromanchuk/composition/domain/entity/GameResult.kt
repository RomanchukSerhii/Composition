package com.gmail.serhiiromanchuk.composition.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings
) : Parcelable {
    val percentOfRightQuestion: Int
        get() = ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
}