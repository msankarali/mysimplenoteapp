package com.msad.mysimplenote

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = this.getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val a: String? = sharedPreferences.getString("note", "")
        editText.setText(a)
        supportActionBar?.hide()
    }


    override fun onPause() {
        super.onPause()
        val sharedPreferences = this.getSharedPreferences(packageName, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("note", editText.text.toString()).apply()
    }
}