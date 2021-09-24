package com.example.guessgame.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.guessgame.R
import com.example.guessgame.databinding.ItemListTileBinding
import com.example.guessgame.utils.TileClickListener

class TileViewHolder(
    private val binding: ItemListTileBinding,
    val tileClickListener: TileClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(containNumber: Boolean) {
        binding.cardView.setCardBackgroundColor(binding.root.context.getColor(R.color.grey))
        binding.cardTextView.text = "Reveal"

        binding.cardView.setOnClickListener {
            tileClickListener.onTileClick(binding, adapterPosition)
        }
    }

}