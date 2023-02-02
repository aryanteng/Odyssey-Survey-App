package com.example.odysseysurvery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtRole: EditText

    private lateinit var btnNext: Button

    private var tag: String = "State Change"
    private lateinit var stateMess: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stateMess = "State of Activity MainActivity is Created"
        stateCallback(stateMess)

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
        stateMess = "State of Activity MainActivity changed from Created to Started"
        stateCallback(stateMess)

    }

    override fun onResume() {
        super.onResume()
        stateMess = "State of Activity MainActivity changed from Started to Resumed"
        stateCallback(stateMess)
    }

    override fun onPause() {
        super.onPause()
        stateMess = "State of Activity MainActivity changed from Resumed to Paused"
        stateCallback(stateMess)
    }

    override fun onStop() {
        super.onStop()
        stateMess = "State of Activity MainActivity changed from Paused to Stopped"
        stateCallback(stateMess)
    }

    override fun onDestroy() {
        super.onDestroy()
        stateMess = "State of Activity MainActivity changed from Stopped to Destroyed"
        stateCallback(stateMess)
    }

    private fun stateCallback(stateMess: String){
        Log.i(tag, stateMess)
        Toast.makeText(this, stateMess, Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val name = edtName.text.toString()
        val role = edtRole.text.toString()
        outState.putString("name", name)
        outState.putString("role", role)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val name = savedInstanceState.getString("name", "")
        edtName.setText(name)
        val role = savedInstanceState.getString("role", "")
        edtRole.setText(role)
    }

}