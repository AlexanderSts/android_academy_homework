package com.test.myapplication.adapters;

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.test.myapplication.DetailsFragment
import com.test.myapplication.providers.MoviesDataProvider

class DetailsFragmentAdapter(
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment? {
        val movie = when {
            position <= count - 1 -> position
            else -> null
        }
        return movie?.run { DetailsFragment.newInstance(this) }
    }

    override fun getCount(): Int {
        return MoviesDataProvider.getSize()
    }
}