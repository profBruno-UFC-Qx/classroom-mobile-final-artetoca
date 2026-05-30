package com.example.artetoca

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun Car(modifier: Modifier = Modifier) {
    var valor by remember { mutableIntStateOf(1) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.artetoca),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(MaterialTheme.shapes.extraLarge)
        )
        Column {
            Text("Item 1")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedIconButton(
                        onClick = { valor -= 1 },
                        enabled = true
                    ) { Text("-") }

                    Text(
                        text = "${valor}",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    OutlinedIconButton(
                        onClick = { valor += 1 }
                    ) { Text("+") }
                }
                Text("R$ ${200}")
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .border(2.dp, Color.Red, MaterialTheme.shapes.medium)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.red_trash),
                        contentDescription = "Remover item",
                        modifier = Modifier.size(24.dp),
//                        tint = Color.RED
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        repeat(10) {
            Car()
        }
    }
}