package com.example.quantumdownload

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quantumdownload.databinding.ActivitySubjectBinding
import com.example.quantumdownload.model.NotesModel
import com.example.quantumdownload.model.PapersModel
import com.example.quantumdownload.model.QuantumModal
import com.example.quantumdownload.model.SubjectModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class SubjectActivity : AppCompatActivity() {
    private var binding: ActivitySubjectBinding? = null
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupActionBar()

        db = FirebaseFirestore.getInstance()

        val quantumlist:ArrayList<String> = ArrayList()
        quantumlist.add("quantum1")
        quantumlist.add("quantum2")
        quantumlist.add("quantum3")
        val quantum: QuantumModal = QuantumModal(quantumlist)

        val noteslist:ArrayList<String> = ArrayList()
        noteslist.add("notes1")
        noteslist.add("notes2")
        noteslist.add("notes3")
        val notes: NotesModel = NotesModel(noteslist)

        val paperslist: ArrayList<String> = ArrayList()
        paperslist.add("paper1")
        paperslist.add("paper2")
        paperslist.add("paper3")
        val paper: PapersModel = PapersModel(paperslist)

        val data: SubjectModel = SubjectModel(4,quantum,notes,paper)
        val dataMap = HashMap<String, Any>()
        dataMap["dstl"] = data

        db.collection("sem4").document("dstl").set(dataMap).addOnSuccessListener {

        }



    }
    private fun setupActionBar(){
        setSupportActionBar(binding?.toolbarSubjectActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_icon)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = ""
        binding?.toolbarSubjectActivity?.setNavigationOnClickListener { onBackPressed() }
    }
}