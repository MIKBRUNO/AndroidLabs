package ru.nsu.mdyachenko2.currency

import androidx.core.util.Consumer
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest

import ru.nsu.mdyachenko2.currency.abs.Currency

class CBRCurrencyLoader(private val queue : RequestQueue) {
    private val url = "https://www.cbr-xml-daily.ru/daily_json.js"

    fun loadCurrencies(l: Consumer<List<Currency>>) {
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            {
                val response = it
                val valutes = response.getJSONObject("Valute")
                val currencies = ArrayList<Currency>()
                for (k in valutes.keys()) {
                    val valute = valutes.getJSONObject(k)
                    currencies.add(CurrencyImpl(
                        charCode = valute.getString("CharCode"),
                        name = valute.getString("Name"),
                        nominal = valute.getInt("Nominal"),
                        value = valute.getDouble("Value"),
                        previous = valute.getDouble("Previous")
                    ))
                }
                l.accept(currencies)
            }, {}
        )
        queue.add(request)
    }
}
