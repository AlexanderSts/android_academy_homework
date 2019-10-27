package com.test.myapplication;

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.test.myapplication.adapters.AdapterMovies
import com.test.myapplication.helpers.GoToUrlHelper
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.test.myapplication.threads_part.CoroutineActivity
import com.test.myapplication.threads_part.ThreadsActivity


class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        /*val adapter = AdapterMovies(this) { position, resource ->
            val intent = DetailsActivity.createIntent(this, position)
            startActivity(intent)
            //GoToUrlHelper.gotoUrl(this, resource)
        }*/

        val adapter = AdapterMovies(this) { position, resource ->
            showDetailsFragment(position)
        }
        val list = findViewById<RecyclerView>(R.id.container_recycler)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = llm
        list.adapter = adapter
    }

    private fun showDetailsFragment(

        position: Int
    ) {
        val detailsFragment = DetailsGalleryFragment.newInstance(position)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(R.id.container, detailsFragment)
            .commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.movies_activity_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_open_coroutine -> {
                // Open Async Task Activity
                startActivity(Intent(this, CoroutineActivity::class.java))
                return true
            }

            R.id.action_open_thread_handler -> {
                // Open Thread Handler Activity
                startActivity(Intent(this, ThreadsActivity::class.java))
                return true
            }

            else ->
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item)
        }
    }
}

