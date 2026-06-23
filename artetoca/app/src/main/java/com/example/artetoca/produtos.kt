package com.example.artetoca

data class Produto(
    val nome: String,
    val preco: String,
    val imagem: Int
)

val bordados = listOf(
    Produto("Bordado Nome", "70,00", R.drawable.bordado1),
    Produto("Bordado de Santo", "70,00", R.drawable.bordado2),
    Produto("Bordado de Santo", "70,00", R.drawable.bordado3)
)

val croches = listOf(
    Produto("Caminho de mesa", "60,00", R.drawable.croche1),
    Produto("Protetor de Galão", "60,00", R.drawable.croche2),
    Produto("Bolsa", "60,00", R.drawable.croche3)
)

val pinturas = listOf(
    Produto("Quadro Praia", "60,00", R.drawable.quadro1),
    Produto("Quadro Casal", "60,00", R.drawable.quadro2),
    Produto("Quadro Pôr do Sol", "60,00", R.drawable.quadro3)
)
val palhas = listOf(
    Produto("Bolsa", "60,00", R.drawable.palha1),
    Produto("Porta prato", "40,00", R.drawable.palha2),
    Produto("Cesto", "40,00", R.drawable.palha3)
)