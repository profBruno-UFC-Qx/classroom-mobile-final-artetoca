package com.example.artetoca

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


val cards = listOf(
    Triple("titulo", "categoria", "descriçao"),
    Triple("titulo", "categoria", "descriçao"),
    Triple("titulo", "categoria", "descriçao"),
    Triple("titulo", "categoria", "descriçao"),
    Triple("titulo", "categoria", "descriçao"),
    Triple("titulo", "categoria", "descriçao")
)

@Composable
fun Card(titulo: String, especialidade: String, descrição: String, modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color(0xffffffff))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier.padding(10.dp)
        ) {
            AsyncImage(
                model = "https://img.icons8.com/3d-fluent/100/user-2.png",
                contentDescription = null, modifier = Modifier.height(100.dp)
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = titulo, fontSize = 16.sp)
                Text(text = especialidade, color = Color(0xffe88ba0))
                Text(text = descrição, color = Color(0xff6d6d6d))
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    Column(Modifier.background(color = Color(0xfffef5f5))) {
        cards.forEach {
            Card(it.first, it.second, it.third)
        }
    }

}