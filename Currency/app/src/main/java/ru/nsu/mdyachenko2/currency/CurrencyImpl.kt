package ru.nsu.mdyachenko2.currency

import ru.nsu.mdyachenko2.currency.abs.Currency

class CurrencyImpl(
    override val charCode: String,
    override val name: String,
    override val value: Double,
    override val nominal: Int,
    override val previous: Double
) : Currency
