package ru.nsu.mdyachenko2.currency.view

import android.content.Intent
import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.nsu.mdyachenko2.currency.abs.Currency
import ru.nsu.mdyachenko2.currency.databinding.CurrencyViewBinding
import java.util.function.Consumer

class CurrencyViewHolder(private val binding: CurrencyViewBinding) : ViewHolder(binding.root) {
    private val format: NumberFormat = DecimalFormat("0.00")

    fun update(currency: Currency) {
        binding.currencyCode.text = currency.charCode
        binding.currencyValue.text = format.format(currency.value)
        binding.currencyNominal.text = currency.nominal.toString()
        binding.currencyName.text = currency.name
    }
}