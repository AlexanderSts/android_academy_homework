package com.test.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.test.myapplication.helpers.GoToUrlHelper


/*
// Created by Alexander Stsenilousky like a demo application for Android Academy Minsk 2019 course
 */
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_constraint)
        findViewById<Button>(R.id.btn_to_movie).setOnClickListener(View.OnClickListener { GoToUrlHelper.gotoUrl(this) })
    }
}
