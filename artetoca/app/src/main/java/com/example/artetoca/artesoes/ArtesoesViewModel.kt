package com.example.artetoca.artesoes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ArtesaosViewModel : ViewModel() {

    private val db = Firebase.firestore

    var artesaos by mutableStateOf<List<Artesao>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        fetchArtesaos()
    }

    private fun fetchArtesaos() {
        db.collection("artesaos") // nome da sua coleção
            .get()
            .addOnSuccessListener { result ->
                artesaos = result.documents.mapNotNull { it.toObject(Artesao::class.java) }
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
            }
    }
}