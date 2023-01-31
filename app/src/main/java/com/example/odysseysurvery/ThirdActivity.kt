package com.example.odysseysurvery

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var role: String
    private lateinit var tvName: TextView
    private lateinit var tvRole: TextView
    private var arr: ArrayList<String> = arrayListOf()
    private var hash: HashMap<String, String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        tvName = findViewById(R.id.tv_name)
        tvRole = findViewById(R.id.tv_role)

        name = intent.getStringExtra("name").toString()
        role = intent.getStringExtra("role").toString()
        arr  = intent.getStringArrayListExtra("map") as ArrayList<String>
        hash = intent.getSerializableExtra("hash") as HashMap<String, String>

        tvName.text = name
        tvRole.text = role


        Log.d("third", arr.toString())
        Log.d("thirdHASH", hash.toString())

    }
}