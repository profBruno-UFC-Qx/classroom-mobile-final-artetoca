package com.example.artetoca.carrinho

import java.util.UUID

data class ItemCardData(
    val img: Int,
    val preco: Int,
    val qtd: Int
) {
    val id: UUID = UUID.randomUUID()
}