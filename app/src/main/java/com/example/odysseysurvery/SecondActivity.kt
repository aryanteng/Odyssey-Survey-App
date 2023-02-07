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
    private var foodRating: String = ""


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

        rbMusic.stepSize = 1f
        rbDance.stepSize = 1f
        rbPlay.stepSize = 1f
        rbFashion.stepSize = 1f
        rbFood.stepSize = 1f

        name = intent.getStringExtra("name").toString()
        role = intent.getStringExtra("role").toString()

        btnClear.setOnClickListener{
           onClearHandler()
        }

        rbMusic.setOnRatingBarChangeListener { _, rating, _ ->
            musicRating = rating.toString()
        }
        rbDance.setOnRatingBarChangeListener { _, rating, _ ->
            danceRating = rating.toString()
        }
        rbPlay.setOnRatingBarChangeListener { _, rating, _ ->
            playRating = rating.toString()
        }
        rbFashion.setOnRatingBarChangeListener { _, rating, _ ->
           fashionRating = rating.toString()
        }
        rbFood.setOnRatingBarChangeListener { _, rating, _ ->
            foodRating = rating.toString()
        }

        btnSubmit.setOnClickListener{
            val bool = onSubmitHandler()
            if(hash.isNotEmpty() && bool){
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

    private fun onSubmitHandler(): Boolean {
        hash.clear()
        if(cbMusic.isChecked){
            if(musicRating > 0.0f.toString()){
                hash["Music"] = musicRating
            }
            else{
                Toast.makeText(this, "Please give a rating to Music!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        if(cbDance.isChecked){
            if(danceRating > 0.0f.toString()){
                hash["Dance"] = danceRating
            }
            else{
                Toast.makeText(this, "Please give a rating to Dance!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        if(cbPlay.isChecked){
            if(playRating > 0.0f.toString()){
                hash["Play"] = playRating
            }
            else{
                Toast.makeText(this, "Please give a rating to Play!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        if(cbFashion.isChecked){
            if(fashionRating > 0.0f.toString()){
                hash["Fashion"] = fashionRating
            }
            else{
                Toast.makeText(this, "Please give a rating to Fashion!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        if(cbFood.isChecked){
            if(foodRating > 0.0f.toString()){
                hash["Food"] = foodRating
            }
            else{
                Toast.makeText(this, "Please give a rating to Food!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        if(musicRating > 0.0f.toString() && !cbMusic.isChecked){
            Toast.makeText(this, "Music is not checked!", Toast.LENGTH_SHORT).show()
            return false
        }
        if(danceRating > 0.0f.toString() && !cbDance.isChecked){
            Toast.makeText(this, "Dance is not checked!", Toast.LENGTH_SHORT).show()
            return false
        }
        if(playRating > 0.0f.toString() && !cbPlay.isChecked){
            Toast.makeText(this, "Play is not checked!", Toast.LENGTH_SHORT).show()
            return false
        }
        if(fashionRating > 0.0f.toString() && !cbFashion.isChecked){
            Toast.makeText(this, "Fashion is not checked!", Toast.LENGTH_SHORT).show()
            return false
        }
        if(foodRating > 0.0f.toString() && !cbFood.isChecked){
            Toast.makeText(this, "Food is not checked!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
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