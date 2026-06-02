package com.example.artetoca

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemCard(preco:Float,qtd:Int,modifier: Modifier = Modifier) {
    var valor by remember { mutableIntStateOf(qtd) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.artetoca),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(MaterialTheme.shapes.extraLarge)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text("Item 1")
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    OutlinedIconButton(
                        onClick = { valor -= 1 },
                        enabled = true,
                        border = BorderStroke(1.dp, Color.Transparent),
                        colors = IconButtonColors(
                            Color(0xfffce4e9),
                            Color(0xff000000),
                            Color(0xfffce4e9),
                            Color(0xfffce4e9)
                        )
                    ) { Text("-") }

                    Text(
                        text = "$valor",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    OutlinedIconButton(
                        onClick = { valor += 1 },
                        border = BorderStroke(1.dp, Color.Transparent),
                        colors = IconButtonColors(
                            Color(0xfffce4e9),
                            Color(0xff000000),
                            Color(0xfffce4e9),
                            Color(0xfffce4e9)
                        )
                    ) { Text("+") }
                }
                Text("R$ ${preco}")
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.trash),
                        contentDescription = "Remover item",
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xffd4183d)
                    )
                }
            }
        }
    }
}


@Composable
fun CardListMock() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(Color(0xfffef5f5))
            .padding(16.dp)
            .verticalScroll(scrollState), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(10) {
            ItemCard(300f,1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarPreview() {
    CardListMock()
}