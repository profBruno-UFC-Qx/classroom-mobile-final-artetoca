package com.example.artetoca.carrinho

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artetoca.R
import com.example.artetoca.ui.theme.ArtetocaPink
import com.example.artetoca.ui.theme.Background

@Composable
fun EmptyCartMessage(
    onExploreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Box(modifier = Modifier
            .background(Color(0xfffdebee), shape = CircleShape)
            .padding(64.dp)) {
            Image(
                painter = painterResource(id = R.drawable.carrinho_vazio_icon),
                modifier = Modifier.size(120.dp),
                contentDescription = null,
            )
        }
        Text(
            text = "Carrinho vazio",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Que tal explorar nossas peças artesanais e encontrar algo especial?",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
        Button(
            onClick = onExploreClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = ArtetocaPink,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Ver Produtos")
        }
        Text(
            text = "Feito com carinho por artesãos locais ✦",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
fun EmptyCartMessagePreview() {
    EmptyCartMessage(onExploreClick = {})
}