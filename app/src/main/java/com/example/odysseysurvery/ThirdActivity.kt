package com.example.odysseysurvery

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var role: String
    private lateinit var tvName: TextView
    private lateinit var tvRole: TextView
    private lateinit var tvEvent: TextView
    private lateinit var tvEvents: TextView
    private var hash: HashMap<String, String> = hashMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

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
            hash.forEach { (key, value) ->
                string += if (value == "") {
                    "$key, Rating: N/A\n"
                } else {
                    Log.d("value", value)
                    "$key, Rating: $value\n"
                }
            }
            tvEvents.text = string
        }
    }
}