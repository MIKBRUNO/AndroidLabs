package ru.nsu.mdyachenko2.currency.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import ru.nsu.mdyachenko2.currency.abs.Currency
import ru.nsu.mdyachenko2.currency.databinding.CurrencyViewBinding
import java.util.function.Consumer

class CurrencyAdapter(private var _currencies : List<Currency>, private val clickListener: Consumer<Currency>) : Adapter<CurrencyViewHolder>() {
    var currencies : List<Currency>
        get() = _currencies
        set(value) {
            _currencies = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CurrencyViewBinding.inflate(layoutInflater, parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return _currencies.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.update(_currencies[position])
        holder.itemView.setOnClickListener {
            clickListener.accept(_currencies[position])
        }
    }
}