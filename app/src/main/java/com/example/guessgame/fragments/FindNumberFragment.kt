package com.example.guessgame.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.guessgame.R
import com.example.guessgame.adapters.TilesAdapter
import com.example.guessgame.databinding.FragmentFindNumberBinding
import com.example.guessgame.databinding.ItemListTileBinding
import com.example.guessgame.utils.Constants
import com.example.guessgame.utils.TileClickListener
import kotlin.properties.Delegates
import kotlin.random.Random


class FindNumberFragment : Fragment(R.layout.fragment_find_number), TileClickListener {

    private lateinit var binding: FragmentFindNumberBinding
    private var attemptsMade = 0
    private val randPosition = Random.nextInt(1, 10)
    private var selectedNumber by Delegates.notNull<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFindNumberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedNumber = arguments?.getInt(Constants.SELECTED_NUMBER_KEY, 0)!!
        Log.e(TAG, "onViewCreated: $selectedNumber")

        binding.tilesRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = TilesAdapter(randPosition, this@FindNumberFragment)
        }
    }

    override fun onTileClick(binding: ItemListTileBinding, position: Int) {
        attemptsMade += 1
        this.binding.attemptsTextView.text = getString(R.string.string_attempts, 3 - attemptsMade)
        if (position == randPosition) {
            binding.cardTextView.text = getString(R.string.string_won, selectedNumber)
            binding.cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            showWinDialog()
        } else {
            binding.cardTextView.text = getString(R.string.string_lost)
            binding.cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.red
                )
            )
            if (attemptsMade == 3)
                showLoseDialog()
        }
    }

    private fun showLoseDialog() {
        Log.e(TAG, "showLoseDialog: ")
        AlertDialog.Builder(requireContext()).setCancelable(false)
            .setTitle("You Lost")
            .setNeutralButton("Retry") { dialogInterface, _ ->
                dialogInterface.dismiss()
                findNavController().navigateUp()
            }
            .create().show()
    }

    private fun showWinDialog() {
        Log.e(TAG, "showWinDialog: ")
        AlertDialog.Builder(requireContext()).setCancelable(false)
            .setTitle("You Win")
            .setNeutralButton("Play Again") { dialogInterface, _ ->
                dialogInterface.dismiss()
                findNavController().navigateUp()
            }
            .create().show()
    }

    companion object {
        private const val TAG = "FindNumberFragment"
    }
}