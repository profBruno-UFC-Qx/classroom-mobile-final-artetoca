package com.example.artetoca.carrinho

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun ItemList(
    items: List<ItemCardData>,
    removeItem: (UUID) -> Unit,
    incrementItem: (UUID, Int) -> Unit,
    decrementItem: (UUID, Int) -> Unit, modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items.forEach { item ->
            ItemCard(item, removeItem, incrementItem, decrementItem)
        }
    }
}