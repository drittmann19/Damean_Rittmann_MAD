package com.example.project_2

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var myExpenseTotals = ExpenseTotals();
    private val REQUEST_CODE = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        updateUI()
    }

    fun updateUI(){
        //total = String.format("%.2f", total).toDouble()
        totalAmountText.text = "$" + String.format("%.2f", myExpenseTotals.total)
        wantAmountText.text = "$" + String.format("%.2f", myExpenseTotals.wantTotal)

        var percent = 0.00
        if (myExpenseTotals.total != 0.00) {
            percent = (myExpenseTotals.wantTotal/myExpenseTotals.total) * 100
        }else{
            percent = 0.00
        }
        wantPercentageText.text = String.format("%.2f", percent) + "%"

        wantProgress(percent)
    }

    fun wantProgress(percent: Double){
        val currentProgress = percent.toInt()
        //https://www.youtube.com/watch?v=xU-Cc41DfTg&ab_channel=CodePalace
        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }

    fun clearData(view: View) {
        myExpenseTotals.total = 0.00
        myExpenseTotals.wantTotal = 0.00
        updateUI()
        saveData()
    }

    fun addExpense(view: View) {
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra("totalVal", myExpenseTotals.total)
        intent.putExtra("wantTotalVal", myExpenseTotals.wantTotal)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)){
            if (data != null) {
                myExpenseTotals.total = data.getDoubleExtra("totalVal", 0.00)
            }
            if (data != null) {
                myExpenseTotals.wantTotal = data.getDoubleExtra("wantTotalVal", 0.00)
            }
            updateUI()
            saveData()
        }
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("totalString", myExpenseTotals.total.toString())
            putString("wantTotalString", myExpenseTotals.wantTotal.toString())
        }.apply()

    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val totalString = sharedPreferences.getString("totalString", null)
        val wantString = sharedPreferences.getString("wantTotalString", null)

        if (totalString != null) {
            myExpenseTotals.total = totalString.toDouble()
        }
        if (wantString != null) {
            myExpenseTotals.wantTotal = wantString.toDouble()
        }
    }


}