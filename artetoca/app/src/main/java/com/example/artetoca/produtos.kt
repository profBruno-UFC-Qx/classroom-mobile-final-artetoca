package com.example.artetoca

import com.example.artetoca.R.drawable

data class Produto(
    val nome: String,
    val preco: String,
    val imagem: Int
)

val bordados = listOf(
    Produto("Bordado Nome", "70,00", drawable.bordado1),
    Produto("Bordado de Santo", "70,00", drawable.bordado2),
    Produto("Bordado de Santo", "70,00", drawable.bordado3)
)

val croches = listOf(
    Produto("Caminho de mesa", "60,00", drawable.croche1),
    Produto("Protetor de Galão", "60,00", drawable.croche2),
    Produto("Bolsa", "60,00", drawable.croche3)
)

val pinturas = listOf(
    Produto("Quadro Praia", "60,00", drawable.quadro1),
    Produto("Quadro Casal", "60,00", drawable.quadro2),
    Produto("Quadro Pôr do Sol", "60,00", drawable.quadro3)
)
val palhas = listOf(
    Produto("Bolsa", "60,00", drawable.palha1),
    Produto("Porta prato", "40,00", drawable.palha2),
    Produto("Cesto", "40,00", drawable.palha3)
)

val macrame = listOf(
    Produto("Bolsa", "60,00", drawable.macrame1),
    Produto("Suporte", "40,00", drawable.macrame2),
    Produto("Vestuário", "120,00", drawable.macrame3)
)

val papel = listOf(
    Produto("Galo", "40,00", drawable.papel1),
    Produto("Galo", "40,00", drawable.papel2),
    Produto("Pássaro", "40,00", drawable.papel3)
)