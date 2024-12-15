package ru.nsu.mdyachenko2.recycler

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.mdyachenko2.recycler.databinding.SongItemBinding

class SongViewHolder(binding: SongItemBinding): RecyclerView.ViewHolder(binding.root) {
    var artist: String
        get() = artistView.text.toString()
        set(value) {
            artistView.text = value
        }
    var song: String
        get() = songView.text.toString()
        set(value) {
            songView.text = value
        }

    private val artistView: TextView = binding.artistTextView
    private val songView: TextView = binding.songTextView
}