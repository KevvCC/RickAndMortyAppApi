package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.response.CharacterResponse
import com.example.rickandmortyapp.databinding.CharactersLayoutBinding

class RickPagedAdapter : PagingDataAdapter<CharacterResponse, RickPagedAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: CharactersLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CharacterResponse>() {
            override fun areItemsTheSame(
                oldItem: CharacterResponse,
                newItem: CharacterResponse
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CharacterResponse,
                newItem: CharacterResponse
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.binding.apply {
                tvName.text = currentItem.name
                tvStatus.text = currentItem.status
                val imageLink = currentItem.image

                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
                when (currentItem.status) {
                    "Alive" -> { tvStatus.setTextColor(ContextCompat.getColor(tvStatus.context, R.color.alive)) }
                    "Dead" -> { tvStatus.setTextColor(ContextCompat.getColor(tvStatus.context, R.color.dead))}
                    else -> { tvStatus.setTextColor(ContextCompat.getColor(tvStatus.context, R.color.unknow)) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CharactersLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}