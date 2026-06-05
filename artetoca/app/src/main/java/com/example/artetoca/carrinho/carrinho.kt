package com.example.artetoca.carrinho

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artetoca.R
import java.util.UUID
import kotlin.random.Random

val itemsMock = listOf(
    ItemCardData(R.drawable._1, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._2, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._3, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._4, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._5, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._6, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._7, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._8, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._9, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._10, Random.nextInt(10, 150), 1),
    ItemCardData(R.drawable._11, Random.nextInt(10, 150), 1),
)

@Composable
fun Carrinho(modifier: Modifier = Modifier) {
    var items by remember { mutableStateOf(itemsMock) }
    val removeItem = { id: UUID ->
        items = items.filter { item -> item.id != id }
    }
    Column(
        modifier = modifier
            .background(Color(0xfffef5f5))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ItemList(items,removeItem, Modifier.weight(1f))
        FinalizerCard(items.sumOf { it.preco }.toFloat())
    }
}

@Preview(showBackground = true)
@Composable
fun CarPreview() {
    Carrinho()
}