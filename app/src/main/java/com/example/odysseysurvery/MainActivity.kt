package com.example.odysseysurvery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtRole: EditText

    private lateinit var btnNext: Button

    private var tag: String = "State Change"
    private lateinit var currState : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(tag, "onCreate")

        btnNext = findViewById(R.id.btn_next)
        edtName = findViewById(R.id.edt_name)
        edtRole = findViewById(R.id.edt_role)

        btnNext.setOnClickListener{
            var name = edtName.text.toString()
            var role = edtRole.text.toString()
            if(name != "" && role != ""){
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("role", role)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please enter the fields!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()

        Log.i(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onDestroy")
    }
    
}