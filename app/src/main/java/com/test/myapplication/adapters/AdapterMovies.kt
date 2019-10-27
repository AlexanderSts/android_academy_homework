package com.test.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.R
import com.test.myapplication.holders.HolderMoviesView
import com.test.myapplication.providers.MoviesDataProvider

class AdapterMovies(context: Context,
                    private val clickListener: (position: Int, resource:Int) -> Unit
)  : RecyclerView.Adapter<HolderMoviesView>() {
    override fun onBindViewHolder(p0: HolderMoviesView, p1: Int) {
        System.out.println("!!! onBindViewHolder " + p1)
        p0.bind(p1, clickListener)
    }
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HolderMoviesView {
        System.out.println("!!! onCreateViewHolder ")
        return HolderMoviesView(inflater.inflate(R.layout.item_movie, p0, false), clickListener)
    }

    override fun getItemCount(): Int {
        System.out.println("!!! getItemCount "+ MoviesDataProvider.getSize())
        return  MoviesDataProvider.getSize()
    }



}