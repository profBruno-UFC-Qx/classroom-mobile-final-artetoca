package com.example.artetoca.artesoes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun UserCard(
    titulo: String,
    descrição: String,
    img_url: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White)
        ) {
            AsyncImage(
                model = img_url,
                contentDescription = null
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = titulo, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "especialidade", color = Color(0xffe88ba0))
                Text(text = descrição, color = Color(0xff6d6d6d), fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun CardMock(modifier: Modifier = Modifier) {
    UserCard("titulo", "categoria", "descriçao")
}

@Preview
@Composable
fun CardPreview() {
    CardMock()
}