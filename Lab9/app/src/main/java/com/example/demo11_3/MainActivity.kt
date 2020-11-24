package com.example.demo11_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var message:String=""
    var review:String=""

    private var myCakeShop = CupcakeReview();
    private var selectedLocationPosition = 0
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //event listener
        reviewButton.setOnClickListener{
            selectedLocationPosition = spinner.selectedItemPosition
            myCakeShop.suggestCupcakePlace(selectedLocationPosition)
            Log.i("shop suggested", myCakeShop.name);
            Log.i("url suggested", myCakeShop.url);

            //intent
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("cakeShopName", myCakeShop.name)
            intent.putExtra("cakeShopURL", myCakeShop.url)

            startActivityForResult(intent, REQUEST_CODE)
        }
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
        reviewTextView.text = review
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)){
            reviewTextView.setText(data?.let{data.getStringExtra("review")})
            review = reviewTextView.text as String
        }
    }
}