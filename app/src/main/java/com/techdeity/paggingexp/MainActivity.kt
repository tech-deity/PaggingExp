package com.techdeity.paggingexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.techdeity.paggingexp.paging.QuotePagingAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var adapter: QuotePagingAdapter
    lateinit var quotesviewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.recycler_view_rv)
        adapter = QuotePagingAdapter()
        quotesviewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        rv.setHasFixedSize(true)
        rv.adapter = adapter

        quotesviewModel.list.observe( this ,{
            adapter.submitData(lifecycle,it)
        })


    }
}