package com.techdeity.paggingexp.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.techdeity.paggingexp.R
import com.techdeity.paggingexp.model.Result

class QuotePagingAdapter:PagingDataAdapter<Result, QuotePagingAdapter.QuoteViewHolder>(COMPARATOR) {

    companion object{

        private val COMPARATOR = object:DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                    return oldItem._id==newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                    return oldItem == newItem
            }

        }
    }


    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {

        val item = getItem(position)
        if(item!=null)
        {
            holder.quotes.text=item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item,parent,false)
        return QuoteViewHolder(view)
    }
    class QuoteViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {


        val quotes = itemview.findViewById<TextView>(R.id.quotes_tv)

    }



}

