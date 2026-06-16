package com.example.artetoca

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Categoria(
    val nome: String
)

val categorias = listOf(
    Categoria("Bordado"),
    Categoria("Quadros"),
    Categoria("Crochê"),
    Categoria("Macramê"),
    Categoria("Amigurimi"),
    Categoria("Papel Machê"),
)

@Composable
fun CategoriaVendas(
    nome: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text (
            text = nome,
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}