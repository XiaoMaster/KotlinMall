package com.xiao.kotlinmall.usercenter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        buttonClick.setOnClickListener { button ->

            Toast.makeText(this, (button as Button).text, Toast.LENGTH_SHORT).show()
        }
    }
}
