package ru.nsu.mdyachenko2.currency.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import ru.nsu.mdyachenko2.currency.CBRCurrencyLoader

import ru.nsu.mdyachenko2.currency.databinding.ActivityCurrencySelectBinding

class CurrencySelectActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCurrencySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencySelectBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = Intent(applicationContext, ExchangerActivity::class.java)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CurrencyAdapter(listOf()) {
            intent.putExtra("currency", it)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val queue = RequestQueue(
            DiskBasedCache(cacheDir, 1024 * 1024),
            BasicNetwork(HurlStack())
        ).apply { start() }
        val loader = CBRCurrencyLoader(queue)
        loader.loadCurrencies {
            adapter.currencies = it
        }
    }
}