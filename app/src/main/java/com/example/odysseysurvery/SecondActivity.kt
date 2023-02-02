package com.example.odysseysurvery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

    private var hash: HashMap<String, String> = hashMapOf()
    private lateinit var name: String
    private lateinit var role: String

    private var tag: String = "State Change"
    private lateinit var stateMess: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        stateMess = "State of Activity SecondActivity is Created"
        stateCallback(stateMess)

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
            if(hash.isNotEmpty()){
                Log.d("hash", hash.toString())
                Toast.makeText(this, "Entry Recorded!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("hash", hash)
                intent.putExtra("name", name)
                intent.putExtra("role", role)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please fill the details!", Toast.LENGTH_SHORT).show()
            }
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
        hash.clear()
        if(cbMusic.isChecked){
            hash["Music"] = edtMusic.text.toString()
        }
        if(cbDance.isChecked){
            hash["Dance"] = edtDance.text.toString()
        }
        if(cbPlay.isChecked){
            hash["Play"] = edtPlay.text.toString()
        }
        if(cbFashion.isChecked){
            hash["Fashion"] = edtFashion.text.toString()
        }
        if(cbFood.isChecked){
            hash["Food"] = edtFood.text.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        stateMess = "State of Activity SecondActivity changed from Created to Started"
        stateCallback(stateMess)

    }

    override fun onResume() {
        super.onResume()
        stateMess = "State of Activity SecondActivity changed from Started to Resumed"
        stateCallback(stateMess)
    }

    override fun onPause() {
        super.onPause()
        stateMess = "State of Activity SecondActivity changed from Resumed to Paused"
        stateCallback(stateMess)
    }

    override fun onStop() {
        super.onStop()
        stateMess = "State of Activity SecondActivity changed from Paused to Stopped"
        stateCallback(stateMess)
    }

    override fun onDestroy() {
        super.onDestroy()
        stateMess = "State of Activity SecondActivity changed from Stopped to Destroyed"
        stateCallback(stateMess)
    }

    private fun stateCallback(stateMess: String){
        Log.i(tag, stateMess)
        Toast.makeText(this, stateMess, Toast.LENGTH_SHORT).show()
    }

}