package com.gmail.serhiiromanchuk.composition.presentation

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gmail.serhiiromanchuk.composition.R
import com.gmail.serhiiromanchuk.composition.databinding.FragmentGameBinding
import com.gmail.serhiiromanchuk.composition.domain.entity.GameResult
import com.gmail.serhiiromanchuk.composition.domain.entity.Level

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    private val args by navArgs<GameFragmentArgs>()

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MainFactory(requireActivity().application, args.level)
        )[GameViewModel::class.java]
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
        observeViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel.gameResult.observe(viewLifecycleOwner) {
            launchGameFinishedFragment(it)
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameFinishedFragment(gameResult))
    }
}