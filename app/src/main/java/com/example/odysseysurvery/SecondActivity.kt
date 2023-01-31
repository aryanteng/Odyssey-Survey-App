package com.example.odysseysurvery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.Dictionary

class SecondActivity : AppCompatActivity() {
    private lateinit var edtMusic: EditText
    private lateinit var edtDance: EditText
    private lateinit var edtPlay: EditText
    private lateinit var edtFashion: EditText
    private lateinit var edtFood: EditText

    private lateinit var btnSubmit: Button
    private lateinit var btnClear: Button

    private lateinit var cbMusic: CheckBox
    private lateinit var cbDance: CheckBox
    private lateinit var cbPlay: CheckBox
    private lateinit var cbFashion: CheckBox
    private lateinit var cbFood: CheckBox

    private val arr: ArrayList<String> = arrayListOf()
    private val hash: HashMap<String, String> = hashMapOf()
    private lateinit var name: String
    private lateinit var role: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        edtMusic = findViewById(R.id.edt_music)
        edtDance = findViewById(R.id.edt_dance)
        edtPlay = findViewById(R.id.edt_play)
        edtFashion = findViewById(R.id.edt_fashion)
        edtFood = findViewById(R.id.edt_food)

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
            Log.d("hash", hash.toString())
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
        edtMusic.setText("")
        edtDance.setText("")
        edtPlay.setText("")
        edtFashion.setText("")
        edtFood.setText("")
5
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
            hash["music"] = edtMusic.text.toString()
            arr.add("music")
        }
        if(cbDance.isChecked){
            hash["dance"] = edtDance.text.toString()
            arr.add("dance")
        }
        if(cbPlay.isChecked){
            hash["play"] = edtPlay.text.toString()
            arr.add("play")
        }
        if(cbFashion.isChecked){
            hash["fashion"] = edtFashion.text.toString()
            arr.add("fashion")
        }
        if(cbFood.isChecked){
            hash["food"] = edtFood.text.toString()
            arr.add("food")
        }

    }
}