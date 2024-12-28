package ru.nsu.mdyachenko2.currency

import ru.nsu.mdyachenko2.currency.abs.Currency
import ru.nsu.mdyachenko2.currency.abs.CurrencyExchanger

class CurrencyExchangerImpl : CurrencyExchanger {
    override fun Exchange(value: Double, currency: Currency) : Double {
        return value * currency.nominal / currency.value
    }
}