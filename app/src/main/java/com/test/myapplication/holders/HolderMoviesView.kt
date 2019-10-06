package com.test.myapplication.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.test.myapplication.R
import com.test.myapplication.providers.MoviesDataProvider.Companion.TYPE_DESCRIPTION
import com.test.myapplication.providers.MoviesDataProvider.Companion.TYPE_IMAGE
import com.test.myapplication.providers.MoviesDataProvider.Companion.TYPE_IMAGE_URL
import com.test.myapplication.providers.MoviesDataProvider.Companion.TYPE_TITLE
import com.test.myapplication.providers.MoviesDataProvider.Companion.getResource
import kotlinx.android.synthetic.main.item_movie.view.*

class HolderMoviesView(
    itemView: View,
    clickListener: (position: Int, resource : Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    fun bind(position: Int, listener: (position: Int, resource: Int) -> Unit) = with(itemView) {
        txt_name.text = context.getText(getResource(TYPE_TITLE, position))
        txt_review.text = context.getText(getResource(TYPE_DESCRIPTION, position))
        img_image.setImageDrawable(context.getDrawable(getResource(TYPE_IMAGE, position)))
        setOnClickListener { listener(position, getResource(TYPE_IMAGE_URL, position)) }
    }


}
