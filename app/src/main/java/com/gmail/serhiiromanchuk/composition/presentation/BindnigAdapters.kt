package com.gmail.serhiiromanchuk.composition.presentation

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.gmail.serhiiromanchuk.composition.R

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("requireAnswers")
fun bindRequireAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_answers),
        count
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, score: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        score
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, percentage: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        percentage
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, score: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        score
    )
}

@BindingAdapter("emojiResult")
fun bindEmojiResult(imageView: ImageView, winner: Boolean) {
    val smileResId = if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
    imageView.setImageResource(smileResId)
}

@BindingAdapter("colorOfRightAnswer")
fun bindColorByState(textView: TextView, goodColor: Boolean) {
    textView.setTextColor(getColorByState(textView, goodColor))
}

@BindingAdapter("colorOfProgressBar")
fun bindColorByState(progressBar: ProgressBar, goodColor: Boolean) {
    val color = getColorByState(progressBar, goodColor)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(view: View, goodColor: Boolean): Int {
    val colorResId = if (goodColor) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(view.context, colorResId)
}

@BindingAdapter("valueToString")
fun bindValueToString(textView: TextView, value: Int) {
    textView.text = value.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}