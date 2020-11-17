package com.example.sharedpref_test


import android.animation.ObjectAnimator
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        progressBar.max = 100

        //https://www.youtube.com/watch?v=S5uLAGnBvUY&ab_channel=CodePalace
        s_button.setOnClickListener{
            saveData()
            wantProgress()
        }
    }

    private fun saveData() {
        val insertedText = et_text.text.toString()
        ds_text.text = insertedText

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedText)
        }.apply()

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)

        ds_text.text = savedString
    }

    fun wantProgress(){
        val currentProgress = 60
        //https://www.youtube.com/watch?v=xU-Cc41DfTg&ab_channel=CodePalace
        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }
}