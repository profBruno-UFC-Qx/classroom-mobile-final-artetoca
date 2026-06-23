package com.example.artetoca.carrinho

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.artetoca.R

@Composable
fun Carrinho(modifier: Modifier = Modifier) {

    val viewModel: CarrinhoViewModel = viewModel()

    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.shopping_cart),
                contentDescription = null,
                tint = Color(0xffe88ba0)
            )
            Spacer(modifier.width(16.dp))
            Text(
                text = "Meu Carrinho",
                fontSize = 24.sp
            )
        }
        Column(
            modifier = modifier
                .background(Color(0xFFFFE6E6))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ItemList(
                viewModel.items,
                { viewModel.removeItem(it) },
                { id, qtd -> viewModel.updateItem(id, qtd + 1) },
                { id, qtd ->
                    if (qtd == 1) viewModel.removeItem(id)
                    else viewModel.updateItem(id, qtd - 1)
                },
                Modifier.weight(1f)
            )
            FinalizerCard(viewModel.items.sumOf { it.preco * it.qtd }.toFloat())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarPreview() {
    Carrinho()
}