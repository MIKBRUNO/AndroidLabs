package ru.nsu.mdyachenko2.currency.abs

import java.io.Serializable

interface Currency : Serializable {
    val charCode : String
    val name : String
    val nominal: Int
    val value : Double
    val previous : Double
}
