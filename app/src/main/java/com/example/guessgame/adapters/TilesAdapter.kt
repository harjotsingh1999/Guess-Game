package com.example.guessgame.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guessgame.databinding.ItemListTileBinding
import com.example.guessgame.utils.TileClickListener
import com.example.guessgame.viewholders.TileViewHolder

class TilesAdapter(private val random: Int, private val tileClickListener: TileClickListener) :
    RecyclerView.Adapter<TileViewHolder>() {
    private val tileCount = 9
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileViewHolder {
        return TileViewHolder(
            ItemListTileBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent, false,
            ),
            tileClickListener
        )
    }

    override fun onBindViewHolder(holder: TileViewHolder, position: Int) {
        holder.bindView(random == position)
    }

    override fun getItemCount(): Int = tileCount
}