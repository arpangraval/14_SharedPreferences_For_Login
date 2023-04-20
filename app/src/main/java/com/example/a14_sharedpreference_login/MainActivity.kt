package com.example.a14_sharedpreference_login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {

            val sharedPreferences = getSharedPreferences("SPLogin", MODE_PRIVATE)
            val editor =sharedPreferences.edit()
            editor.apply{
            putString("id",idET.text.toString())
                putString("pass",passET.text.toString())

            }.apply()
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show()
        }
        try{
            loadData()
        }
        catch (e:Exception){
            Toast.makeText(this,e.message.toString(),Toast.LENGTH_LONG).show()
        }
    }


    private fun loadData() {
        val sharedPreferences = getSharedPreferences("SPLogin", MODE_PRIVATE)
        idET.setText(sharedPreferences.getString("id",null))
        passET.setText(sharedPreferences.getString("pass",null))
    }
}