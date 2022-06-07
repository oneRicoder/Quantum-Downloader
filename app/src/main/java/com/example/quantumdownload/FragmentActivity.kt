package com.example.quantumdownload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quantumdownload.databinding.ActivityFragmentBinding
import com.example.quantumdownload.fragments.NotesFragment
import com.example.quantumdownload.fragments.PapersFragment
import com.example.quantumdownload.fragments.QuantumFragment

class FragmentActivity : AppCompatActivity() {
    private var binding: ActivityFragmentBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (intent.hasExtra("sem")){
            val position = intent.getIntExtra("sem",4)
            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
        }
        replaceFragment(QuantumFragment())
        binding?.quantum?.setOnClickListener {
            replaceFragment(QuantumFragment())
        }
        binding?.notes?.setOnClickListener {
            replaceFragment(NotesFragment())
        }
        binding?.papers?.setOnClickListener {
            replaceFragment(PapersFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}