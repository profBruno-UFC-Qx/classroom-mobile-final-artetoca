package com.example.artetoca.artesoes

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class ArtesaoRepository {
    private val db = Firebase.firestore

    suspend fun getArtesaos(): List<Artesao> {
        return db.collection("artesaos")
            .get()
            .await()
            .documents
            .mapNotNull { it.toObject(Artesao::class.java) }
    }
}