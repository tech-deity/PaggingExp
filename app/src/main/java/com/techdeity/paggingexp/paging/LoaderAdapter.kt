package com.techdeity.paggingexp.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.graphics.createBitmap
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.LoadStates
import androidx.recyclerview.widget.RecyclerView
import com.techdeity.paggingexp.R

class LoaderAdapter  :LoadStateAdapter<LoaderAdapter.LoaderViewHolder>(){


    class LoaderViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val progressBar = itemView.findViewById<ProgressBar>(R.id.progress_bar)

        fun bind(loadState: LoadState){

            progressBar.isVisible = loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.loader_item,parent,false)
            return LoaderViewHolder(view)
    }
}