package com.example.odysseysurvery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import java.util.Dictionary

class SecondActivity : AppCompatActivity() {
    private lateinit var btnSubmit: Button
    private lateinit var btnClear: Button
    private lateinit var cbMusic: CheckBox
    private lateinit var cbDance: CheckBox
    private lateinit var cbPlay: CheckBox
    private lateinit var cbFashion: CheckBox
    private lateinit var cbFood: CheckBox
    private val arr: ArrayList<String> = arrayListOf()
    private lateinit var name: String
    private lateinit var role: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnSubmit = findViewById(R.id.btn_submit)
        btnClear = findViewById(R.id.btn_clear)
        cbMusic = findViewById(R.id.cb_music)
        cbDance = findViewById(R.id.cb_dance)
        cbPlay = findViewById(R.id.cb_play)
        cbFashion = findViewById(R.id.cb_fashion)
        cbFood = findViewById(R.id.cb_food)

        name = intent.getStringExtra("name").toString()
        role = intent.getStringExtra("role").toString()

        btnClear.setOnClickListener{
           onClearHandler()
        }

        btnSubmit.setOnClickListener{
            onSubmitHandler()
            Log.d("tag", arr.toString())
            Log.d("tag2", arr.javaClass.toString())
            Toast.makeText(this, "Entry Recorded!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("map", arr)
            intent.putExtra("name", name)
            intent.putExtra("role", role)
            startActivity(intent)
        }
    }

    private fun onClearHandler(){
        if(cbMusic.isChecked){
            cbMusic.toggle()
        }
        if(cbDance.isChecked){
            cbDance.toggle()
        }
        if(cbPlay.isChecked){
            cbPlay.toggle()
        }
        if(cbFashion.isChecked){
            cbFashion.toggle()
        }
        if(cbFood.isChecked) {
            cbFood.toggle()
        }
    }

    private fun onSubmitHandler(){
        arr.clear()
        if(cbMusic.isChecked){
            arr.add("music")
        }
        if(cbDance.isChecked){
            arr.add("dance")
        }
        if(cbPlay.isChecked){
            arr.add("play")
        }
        if(cbFashion.isChecked){
            arr.add("fashion")
        }
        if(cbFood.isChecked){
            arr.add("food")
        }

    }





}