package com.example.quantumdownload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quantumdownload.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupActionBar()
        var images: ArrayList<Int> = ArrayList()
        images.add(R.drawable.sem_1)
        images.add(R.drawable.sem_2)
        images.add(R.drawable.sem_3)
        images.add(R.drawable.sem_4)
        images.add(R.drawable.sem_5)
        images.add(R.drawable.sem_6)
        images.add(R.drawable.sem_7)
        images.add(R.drawable.sem_8)
        recyclerViewSetup(images)
    }
    private fun recyclerViewSetup(imageList: ArrayList<Int>){
        binding?.rvSemesterImages?.layoutManager = GridLayoutManager(this, 2)
        binding?.rvSemesterImages?.setHasFixedSize(true)

        val adapter = ItemAdapter(this, imageList)
        binding?.rvSemesterImages?.adapter = adapter
    }
    private fun setupActionBar(){
        setSupportActionBar(binding?.toolbarMainActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_icon)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = ""
        binding?.toolbarMainActivity?.setNavigationOnClickListener { onBackPressed() }
    }
}