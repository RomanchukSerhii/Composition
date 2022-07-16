package com.gmail.serhiiromanchuk.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.serhiiromanchuk.composition.R
import com.gmail.serhiiromanchuk.composition.data.GameRepositoryImpl
import com.gmail.serhiiromanchuk.composition.databinding.FragmentGameBinding
import com.gmail.serhiiromanchuk.composition.domain.entity.GameResult
import com.gmail.serhiiromanchuk.composition.domain.entity.GameSettings
import com.gmail.serhiiromanchuk.composition.domain.entity.Level

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")
    private lateinit var level: Level

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOptions1.setOnClickListener {
            val gameSettings = GameRepositoryImpl.getGameSettings(level)
            val gameResult = GameResult(
                winner = true,
                countOfRightAnswers = 15,
                countOfQuestions = 20,
                gameSettings = gameSettings
            )
            launchGameFinishedFragment(gameResult)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    private fun parseArgs() {
        level =
            requireArguments().getParcelable(KEY_LEVEL) ?: throw RuntimeException("Level not found")
    }

    companion object {
        const val NAME = "GameFragment"
        private const val KEY_LEVEL = "KEY_LEVEL"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }
}