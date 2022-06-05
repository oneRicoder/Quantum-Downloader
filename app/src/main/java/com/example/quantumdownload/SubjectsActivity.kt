package com.example.quantumdownload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SubjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        if (intent.hasExtra("position")){
            val position = intent.getIntExtra("position",0)
            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}