package com.example.odysseysurvery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var btnSubmit: Button
    private lateinit var btnClear: Button

    private lateinit var cbMusic: CheckBox
    private lateinit var cbDance: CheckBox
    private lateinit var cbPlay: CheckBox
    private lateinit var cbFashion: CheckBox
    private lateinit var cbFood: CheckBox

    private lateinit var rbMusic: RatingBar
    private lateinit var rbDance: RatingBar
    private lateinit var rbPlay: RatingBar
    private lateinit var rbFashion: RatingBar
    private lateinit var rbFood: RatingBar

    private var musicRating: String = ""
    private var danceRating: String = ""
    private var playRating: String = ""
    private var fashionRating: String = ""
    private var foodRating: String = "1"


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

        btnSubmit = findViewById(R.id.btn_submit)
        btnClear = findViewById(R.id.btn_clear)

        cbMusic = findViewById(R.id.cb_music)
        cbDance = findViewById(R.id.cb_dance)
        cbPlay = findViewById(R.id.cb_play)
        cbFashion = findViewById(R.id.cb_fashion)
        cbFood = findViewById(R.id.cb_food)

        rbMusic = findViewById(R.id.rb_music)
        rbDance = findViewById(R.id.rb_dance)
        rbPlay = findViewById(R.id.rb_play)
        rbFashion = findViewById(R.id.rb_fashion)
        rbFood = findViewById(R.id.rb_food)

        name = intent.getStringExtra("name").toString()
        role = intent.getStringExtra("role").toString()

        btnClear.setOnClickListener{
           onClearHandler()
        }

        rbMusic.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Log.d("HEY", rating.toString())
            musicRating = rating.toString()
        }
        rbDance.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Log.d("HEY", rating.toString())
            danceRating = rating.toString()
        }
        rbPlay.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Log.d("HEY", rating.toString())
            playRating = rating.toString()
        }
        rbFashion.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Log.d("HEY", rating.toString())
           fashionRating = rating.toString()
        }
        rbFood.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Log.d("HEY", rating.toString())
            foodRating = rating.toString()
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
        rbMusic.rating = 0.0f
        rbDance.rating = 0.0f
        rbPlay.rating = 0.0f
        rbFashion.rating = 0.0f
        rbFood.rating = 0.0f
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
        hash.clear()
    }

    private fun onSubmitHandler(){
        hash.clear()
        if(cbMusic.isChecked){
            hash["Music"] = musicRating
        }
        if(cbDance.isChecked){
            hash["Dance"] = danceRating
        }
        if(cbPlay.isChecked){
            hash["Play"] = playRating
        }
        if(cbFashion.isChecked){
            hash["Fashion"] = fashionRating
        }
        if(cbFood.isChecked){
            hash["Food"] = foodRating
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