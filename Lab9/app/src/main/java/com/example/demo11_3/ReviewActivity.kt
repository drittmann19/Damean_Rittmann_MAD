package com.example.demo11_3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.content_review.*

class ReviewActivity : AppCompatActivity() {
    private var cakeShopName: String? = null
    private var cakeShopUrl : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        setSupportActionBar(findViewById(R.id.toolbar))

        cakeShopName = intent.getStringExtra("cakeShopName")
        cakeShopUrl = intent.getStringExtra("cakeShopURL")

        cakeShopName?.let{ Log.i("shop recieved", it)};
        cakeShopUrl?.let{ Log.i("url recieved", it)};

        cakeShopName?.let {cakeShopTextView.text = "You should get cupcakes at $cakeShopName"}

        fab.setOnClickListener{
            loadWebSite()
        }
    }

    fun loadWebSite(){
        //create intent
        var intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = cakeShopUrl?.let {Uri.parse(cakeShopUrl)}
        //Log.i("test1", intent.data.toString())

        //verify
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Log.i("test2", "here")
        }
    }

    override fun onBackPressed() {
        val data = Intent()
        data.putExtra("review", ReviewEditText.text.toString())
        setResult(Activity.RESULT_OK, data)
        super.onBackPressed()
        finish()
    }
}