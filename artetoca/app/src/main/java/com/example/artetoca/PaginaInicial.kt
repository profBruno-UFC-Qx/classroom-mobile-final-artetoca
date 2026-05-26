package com.example.artetoca

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PaginaInicial(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.artetoca)
    val Rosa = Color(0xFFFEF5F5)
    val RosaTitulo = Color(0xFFE88BA0)

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = image,
                contentDescription = "Logo da associacao",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Artetoca",
                    fontSize = 24.sp,
                    color = RosaTitulo,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                )
                Text(
                    text = "Arte feita com amor",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                )
            }
        }
        Spacer(modifier = Modifier.width(5.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Rosa)
                .padding(horizontal = 24.dp)
        ) {
            item {

                Text(
                    text = "Explore nossas categorias",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(24.dp)

                )
            }
        }
    }
}