package ru.nsu.mdyachenko2.currency.abs

interface CurrencyExchanger {
    fun Exchange(value: Double, currency: Currency) : Double
}
