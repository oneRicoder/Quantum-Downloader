package com.example.quantumdownload.model

data class SubjectModel(
    val semesterId: Int,
    val quantums: QuantumModal,
    val notes: NotesModel,
    val papers: PapersModel
)
