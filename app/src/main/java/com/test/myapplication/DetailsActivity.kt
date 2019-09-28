package com.test.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast


/*
// Created by Alexander Stsenilousky like a demo application for Android Academy Minsk 2019 course
 */
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_constraint)
        var button = findViewById<Button>(R.id.btn_to_movie)
        button.setOnClickListener(View.OnClickListener { gotoUrl() })

    }

    fun gotoUrl() {
        val intent =
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6ZfuNTqbHE8"))

        val packageManager = getPackageManager()
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.toast_no_intent, Toast.LENGTH_SHORT).show()
        }
    }
}
