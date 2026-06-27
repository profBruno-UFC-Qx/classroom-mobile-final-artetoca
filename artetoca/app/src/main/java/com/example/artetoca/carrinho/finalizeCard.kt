package com.example.artetoca.carrinho

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FinalizerCard(valorTotal:Float, modifier: Modifier = Modifier) {
    val Rosa = Color(0xFFE88BA0)
    Column(
        modifier = modifier
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Preço:",
                fontWeight = FontWeight.Light,
                fontSize = 16.sp
                )
            Text(
                text = "R$ $valorTotal",
                fontWeight = FontWeight.Light,
                fontSize = 16.sp)
        }
        TextButton(
            onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .background(Rosa, shape = MaterialTheme.shapes.medium)
        ) {
            Text(
                text = "Finalizar pedido",
                fontWeight = FontWeight.Light,
                fontSize = 24.sp
            )
        }
        Text(
            text = "Você será redirecionado para o WhatsApp para concluir seu pedido",
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center
        )
    }
}