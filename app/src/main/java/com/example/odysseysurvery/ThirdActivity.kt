package com.example.odysseysurvery

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private var arr: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        arr = intent.getStringArrayListExtra("map") as ArrayList<String>
        Log.d("third", arr.toString())


    }

}