package com.example.artetoca.carrinho

import java.util.UUID

data class ItemCardData(
    val nome: String,
    val img: Int,
    val preco: Float,
    val qtd: Int
) {
    val id: UUID = UUID.randomUUID()
}