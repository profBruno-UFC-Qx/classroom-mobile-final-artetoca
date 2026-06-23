package com.example.artetoca.artesoes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.artetoca.Banner

@Composable
fun Artesoes(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = Color(0xfffef5f5))
    ) {
        Banner()
        repeat(5) {
            CardMock()
        }
        FinalCard()
    }
}

@Preview
@Composable
fun ArtesoesPreview() {
    Artesoes()
}