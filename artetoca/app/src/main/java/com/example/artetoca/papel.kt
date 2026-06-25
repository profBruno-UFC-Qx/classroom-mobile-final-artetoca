package com.example.artetoca

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.artetoca.R.drawable
import com.example.artetoca.ui.theme.ArtetocaTheme

@Composable
fun CardProdutoPapel(produto: Produto) {
    val Rosa = Color(0xFFE88BA0)
    val RosaClaro = Color(0xFFF9E7EA)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(RosaClaro)
            .padding(horizontal = 12.dp,
                vertical = 8.dp ),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(produto.imagem),
                contentDescription = produto.nome,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Transparent)
                    .padding(12.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = produto.nome,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraLight
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = produto.preco,
                    color = Rosa,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Rosa
                ),
                shape = RoundedCornerShape(12.dp)
            ) {

                Spacer(modifier = Modifier.width(6.dp))

                Text("Comprar")
            }

        }
    }
}

@Composable
fun papel( modifier: Modifier = Modifier) {
    val image = painterResource(drawable.artetoca)
    val Rosa = Color(0xFFFEF5F5)
    val RosaTitulo = Color(0xFFE88BA0)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
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
                    fontWeight = FontWeight.Light,
                    color = RosaTitulo,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                )
                Text(
                    text = "Arte feita com amor",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                )
            }
        }

       // Spacer(modifier = Modifier.height(24.dp))

        papel.forEach { produto ->
            CardProdutoPapel(produto = produto)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun papelPreview() {
    ArtetocaTheme {
        papel()
    }
}
