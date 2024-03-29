package com.test.myapplication.adapters;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.test.myapplication.DetailsFragment
import com.test.myapplication.providers.MoviesDataProvider

class DetailsFragmentAdapter(
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        val movie = when {
            position <= count - 1 -> position
            else -> null
        }
        return movie.run { DetailsFragment.newInstance(position) }
    }

    override fun getCount(): Int {
        return MoviesDataProvider.getSize()
    }
}