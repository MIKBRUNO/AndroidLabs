package ru.nsu.mdyachenko2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.serpro69.kfaker.music.MusicFaker
import ru.nsu.mdyachenko2.recycler.databinding.SongItemBinding

class ContinuousAdapter(recyclerView: RecyclerView) : RecyclerView.Adapter<SongViewHolder>() {
    private val initSize = 30
    private val insertTriggerPosition = 5
    private val insertSize = 10

    private var items: List<Pair<String, String>> = listOf()

    private val faker: MusicFaker = MusicFaker()
    private fun generateNewItems(size: Int) {
        for (i in 1..size) {
            items += (Pair(faker.rockBand.song(), faker.rockBand.name()))
        }
    }

    init {
        generateNewItems(initSize)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisible = layoutManager.findLastCompletelyVisibleItemPosition()
                if (lastVisible >= items.size - insertTriggerPosition) {
                    val startPosition = items.size
                    generateNewItems(insertSize)
                    notifyItemRangeInserted(startPosition, insertSize)
                }
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SongItemBinding.inflate(layoutInflater, parent, false)
        return SongViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.song = items[position].first
        holder.artist = items[position].second
    }
}