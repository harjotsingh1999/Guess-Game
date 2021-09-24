package com.example.guessgame.utils

import com.example.guessgame.databinding.ItemListTileBinding

interface TileClickListener {
    fun onTileClick(
        binding: ItemListTileBinding, position: Int
    )
}