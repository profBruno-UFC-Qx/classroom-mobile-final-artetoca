package com.example.artetoca.artesoes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Artesoes(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val viewModel: ArtesaosViewModel = viewModel()
    val artesaos by viewModel.artesaos.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = Color(0xfffef5f5))
    ) {
        Banner()
        Column {
            artesaos.forEach {
                UserCard(it.nome, it.descricao, it.img)
            }
        }
        FinalCard()
    }
}

@Preview
@Composable
fun ArtesoesPreview() {
    Artesoes()
}