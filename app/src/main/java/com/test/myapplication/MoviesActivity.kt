package com.test.myapplication;

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.test.myapplication.adapters.AdapterMovies
import com.test.myapplication.helpers.GoToUrlHelper
import android.support.v7.widget.LinearLayoutManager



class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val adapter = AdapterMovies(this) { position, resource ->
            val intent = DetailsActivity.createIntent(this, position)
            startActivity(intent)
            //GoToUrlHelper.gotoUrl(this, resource)
        }
        val list = findViewById<RecyclerView>(R.id.container_recycler)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = llm
        list.adapter = adapter
    }
}

