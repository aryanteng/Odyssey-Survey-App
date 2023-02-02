package com.example.odysseysurvery

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var role: String

    private lateinit var tvName: TextView
    private lateinit var tvRole: TextView
    private lateinit var tvEvent: TextView
    private lateinit var tvEvents: TextView

    private var hash: HashMap<String, String> = hashMapOf()

    private var tag: String = "State Change"
    private lateinit var stateMess: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        stateMess = "State of Activity ThirdActivity is Created"
        stateCallback(stateMess)

        tvName = findViewById(R.id.tv_name)
        tvRole = findViewById(R.id.tv_role)
        tvEvent = findViewById(R.id.event_heading)
        tvEvents = findViewById(R.id.tv_events)

        name = intent.getStringExtra("name").toString()
        role = intent.getStringExtra("role").toString()
        hash = intent.getSerializableExtra("hash") as HashMap<String, String>

        tvName.text = name
        tvRole.text = role

        checkEvents()

        Log.d("thirdHASH", hash.toString())
    }

    private fun checkEvents(){
        if(hash.isNotEmpty()) {
            tvEvent.text = "Events:"
            var string = ""
            var count = 1
            hash.forEach { (key, value) ->
                if (value == "") {
                    string += "$count. $key, Rating: N/A\n"
                    count++
                } else {
                    string += "$count. $key, Rating: $value\n"
                    count++
                }
            }
            tvEvents.text = string
        }
    }

    override fun onStart() {
        super.onStart()
        stateMess = "State of Activity ThirdActivity changed from Created to Started"
        stateCallback(stateMess)

    }

    override fun onResume() {
        super.onResume()
        stateMess = "State of Activity ThirdActivity changed from Started to Resumed"
        stateCallback(stateMess)
    }

    override fun onPause() {
        super.onPause()
        stateMess = "State of Activity ThirdActivity changed from Resumed to Paused"
        stateCallback(stateMess)
    }

    override fun onStop() {
        super.onStop()
        stateMess = "State of Activity ThirdActivity changed from Paused to Stopped"
        stateCallback(stateMess)
    }

    override fun onDestroy() {
        super.onDestroy()
        stateMess = "State of Activity ThirdActivity changed from Stopped to Destroyed"
        stateCallback(stateMess)
    }

    private fun stateCallback(stateMess: String){
        Log.i(tag, stateMess)
        Toast.makeText(this, stateMess, Toast.LENGTH_SHORT).show()
    }
}