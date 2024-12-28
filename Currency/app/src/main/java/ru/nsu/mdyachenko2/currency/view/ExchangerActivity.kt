package ru.nsu.mdyachenko2.currency.view

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.mdyachenko2.currency.CurrencyExchangerImpl
import ru.nsu.mdyachenko2.currency.abs.Currency
import ru.nsu.mdyachenko2.currency.abs.CurrencyExchanger
import ru.nsu.mdyachenko2.currency.databinding.ActivityExchangerBinding

class ExchangerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityExchangerBinding
    private val format: NumberFormat = DecimalFormat("0.0000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExchangerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val currency: Currency = intent.getSerializableExtra("currency", Currency::class.java)!!
        binding.currencyName.text = currency.name
        binding.currencyCode.text = currency.charCode

        val exchanger = CurrencyExchangerImpl()
        binding.button.setOnClickListener {
            val value = binding.currencyValueInput.getNumericValue()
            val result = exchanger.Exchange(value, currency)
            binding.currencyValueOutput.text = format.format(result)
        }
    }
}