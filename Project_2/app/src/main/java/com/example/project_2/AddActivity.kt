package com.example.project_2

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    private var totalVal : Double? = null
    private var wantTotalVal : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        totalVal = intent.getDoubleExtra("totalVal", 0.00)
        wantTotalVal = intent.getDoubleExtra("wantTotalVal", 0.00)

//        totalVal?.let { Log.i("total recieved", it.toString())};
//        totalVal?.let { Log.i("total recieved", it.toString())};
    }

    fun enterExpense(view: View) {
        totalVal = intent.getDoubleExtra("totalVal", 0.00)
        wantTotalVal = intent.getDoubleExtra("wantTotalVal", 0.00)
        var amount = 0.0

        if(amountTextEdit.text.toString() == ""){
            val snackbar = Snackbar.make(secondLayout, "Please enter an amount", Snackbar.LENGTH_SHORT)
            snackbar.show()
            return
        }else{
            amount = amountTextEdit.text.toString().toDouble()
        }

        val expenseType = expenseRadioGroup.checkedRadioButtonId
        val type = findViewById<RadioButton>(expenseType).text
        if(type == "Need"){
            totalVal = totalVal!! + amount
        }else{
            totalVal = totalVal!! + amount
            wantTotalVal = wantTotalVal!! + amount
        }

        Log.i("total", totalVal.toString())
        Log.i("want total", wantTotalVal.toString())


        val data = Intent()
        data.putExtra("totalVal", totalVal!!)
        data.putExtra("wantTotalVal", wantTotalVal!!)
        setResult(Activity.RESULT_OK, data)
        finish()
    }


}