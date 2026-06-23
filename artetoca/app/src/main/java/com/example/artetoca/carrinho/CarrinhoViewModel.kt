package com.example.artetoca.carrinho

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.artetoca.R
import java.util.UUID
import kotlin.random.Random

class CarrinhoViewModel : ViewModel() {

    val items = mutableStateListOf(
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

    fun updateItem(id: UUID, novaQuantidade: Int) {
        val index = items.indexOfFirst { it.id == id }
        if (index != -1) {
            items[index] = items[index].copy(qtd = novaQuantidade)
        }
    }
    fun removeItem(id: UUID) {
        items.removeIf { it.id == id }
    }
}