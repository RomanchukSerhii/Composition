package com.gmail.serhiiromanchuk.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.serhiiromanchuk.composition.R
import com.gmail.serhiiromanchuk.composition.databinding.FragmentChooseLevelBinding


class ChooseLevelFragment : Fragment() {
    private lateinit var binding: FragmentChooseLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

}