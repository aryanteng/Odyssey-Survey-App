package com.example.odysseysurvery

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var role: String

    private lateinit var tvName: TextView
    private lateinit var tvRole: TextView
    private lateinit var tvEvent: TextView

    private lateinit var rbMusic: RatingBar
    private lateinit var rbDance: RatingBar
    private lateinit var rbPlay: RatingBar
    private lateinit var rbFashion: RatingBar
    private lateinit var rbFood: RatingBar

    private lateinit var layoutMusic: LinearLayout
    private lateinit var layoutDance: LinearLayout
    private lateinit var layoutPlay: LinearLayout
    private lateinit var layoutFashion: LinearLayout
    private lateinit var layoutFood: LinearLayout


    private var hash: HashMap<String, String> = hashMapOf()

    private var tag: String = "State Change"
    private lateinit var stateMess: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        stateMess = "State of Activity ThirdActivity is Created"
        stateCallback(stateMess)

        layoutMusic = findViewById(R.id.layout_music)
        layoutDance = findViewById(R.id.layout_dance)
        layoutPlay = findViewById(R.id.layout_play)
        layoutFashion = findViewById(R.id.layout_fashion)
        layoutFood = findViewById(R.id.layout_food)


        tvName = findViewById(R.id.tv_name)
        tvRole = findViewById(R.id.tv_role)
        tvEvent = findViewById(R.id.event_heading)

        rbMusic = findViewById(R.id.rb_music)
        rbDance = findViewById(R.id.rb_dance)
        rbPlay = findViewById(R.id.rb_play)
        rbFashion = findViewById(R.id.rb_fashion)
        rbFood = findViewById(R.id.rb_food)

        name = intent.getStringExtra("name").toString()
        role = intent.getStringExtra("role").toString()
        hash = intent.getSerializableExtra("hash") as HashMap<String, String>

        tvName.text = name
        tvRole.text = role

        checkEvents()

    }

    private fun checkEvents(){
        if(hash.isNotEmpty()) {
            tvEvent.visibility = View.VISIBLE
            if(hash.contains("Music") && hash["Music"] != ""){
                rbMusic.rating = hash["Music"]!!.toFloat()
                layoutMusic.visibility = View.VISIBLE
            }
            if(hash.contains("Dance") && hash["Dance"] != ""){
                rbDance.rating = hash["Dance"]!!.toFloat()
                layoutDance.visibility = View.VISIBLE
            }
            if(hash.contains("Play") && hash["Play"] != ""){
                rbPlay.rating = hash["Play"]!!.toFloat()
                layoutPlay.visibility = View.VISIBLE
            }
            if(hash.contains("Fashion") && hash["Fashion"] != ""){
                rbFashion.rating = hash["Fashion"]!!.toFloat()
                layoutFashion.visibility = View.VISIBLE
            }
            if(hash.contains("Food") && hash["Food"] != ""){
                rbFood.rating = hash["Food"]!!.toFloat()
                layoutFood.visibility = View.VISIBLE
            }
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