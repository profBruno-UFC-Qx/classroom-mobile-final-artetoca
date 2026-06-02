package com.example.artetoca

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FinalCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .height(150.dp)
            .background(Color(0xE1FDD7E0), shape = MaterialTheme.shapes.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Faça parte da nossa família",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xffec9daf),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Quer se tornar um artesão da Artetoca? Entre em contato conosco!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xff6c6b6b).copy(0.8f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, start = 24.dp, end = 24.dp)
        )
    }
}

@Composable
fun Artesoes(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = Color(0xfffef5f5))
    ) {
        Banner()
        CardMock()
        FinalCard()
    }
}

@Preview
@Composable
fun ArtesoesPreview() {
    Artesoes()
}