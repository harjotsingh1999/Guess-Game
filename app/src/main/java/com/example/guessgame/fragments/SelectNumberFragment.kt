package com.example.guessgame.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.guessgame.R
import com.example.guessgame.databinding.FragmentSelectNumberBinding
import com.example.guessgame.utils.Constants


class SelectNumberFragment : Fragment(R.layout.fragment_select_number) {

    lateinit var binding: FragmentSelectNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectNumberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.selectNumberPicker.apply {
            minValue = 0
            maxValue = 100
        }
        binding.goButton.setOnClickListener {
            Log.e(TAG, "onViewCreated: clicked ${findNavController()}")
            findNavController().navigate(
                R.id.action_selectNumberFragment_to_findNumberFragment,
                bundleOf(Constants.SELECTED_NUMBER_KEY to binding.selectNumberPicker.value)
            )
        }
    }

    companion object {
        private const val TAG = "SelectNumberFragment"
    }
}