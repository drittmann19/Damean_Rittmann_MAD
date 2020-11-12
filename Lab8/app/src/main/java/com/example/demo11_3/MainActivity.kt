package com.example.demo11_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var message:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createTaco(view: View) {
        var filling:CharSequence = ""
        var toppingList = "" //string
        var frosting = ""

        val fillingId = radioGroup.checkedRadioButtonId

        if(fillingId == -1){
            //snackbar
            val fillingSnackbar = Snackbar.make(rootLayout, "Please select a cake type", Snackbar.LENGTH_SHORT)
            fillingSnackbar.show()
        } else {
            filling = findViewById<RadioButton>(fillingId).text

            //checkboxes
            if (checkBox1.isChecked){
                toppingList += " " + checkBox1.text
            }
            if (checkBox2.isChecked){
                toppingList += " " + checkBox2.text
            }
            if (toppingList.isNotEmpty()){
                toppingList = "and" + toppingList
            }

            val amount = spinner.selectedItem

            if (switch1.isChecked){
                frosting = "with chocolate frosting"
            }
            else{
                frosting = "with vanilla frosting"
            }

            messageTextView.text = "You'd like $amount $filling cupcake(s) $frosting $toppingList"
            message = messageTextView.text as String
            updateUI()
        }
    }

    fun updateUI(){
        messageTextView.text = message
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("message", "")
        updateUI()
    }
}