package com.example.artetoca.carrinho

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.util.UUID
import com.example.artetoca.Produto


class CarrinhoViewModel : ViewModel() {
    val items = mutableStateListOf<ItemCardData>()

    fun adicionarItem(produto : Produto) {
        val precoFloat = produto.preco
            .toFloatOrNull() ?: Of

        val index = items.indexOfFirst { it.nome == produto.nome && it.img == produto.imagem }
        if(index != -1) {
            items[index] = items[index].copy( qtd = items[index].qtd + 1)
        } else {
            items.add(ItemCardData(produto.nome, produto.imagem, precoFloat, 1))
        }
    }

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