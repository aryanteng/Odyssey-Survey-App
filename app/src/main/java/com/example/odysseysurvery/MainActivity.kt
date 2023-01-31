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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                Log.d("maa chuda", name)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please enter the fields!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}