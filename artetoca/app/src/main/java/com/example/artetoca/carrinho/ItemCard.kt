package com.example.artetoca.carrinho

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artetoca.R
import java.util.UUID

@Composable
fun ItemCard(
    item: ItemCardData,
    removeItem: (UUID) -> Unit,
    incrementItem: (UUID, Int) -> Unit,
    decrementItem: (UUID, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.img),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(MaterialTheme.shapes.large)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = "item1",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                ItemCounter(
                    item.qtd,
                    { decrementItem(item.id, item.qtd) },
                    { incrementItem(item.id, item.qtd) })
                Spacer(modifier = Modifier.weight(1f))
                Text("R$ ${item.preco * item.qtd}")
                IconButton(
                    onClick = { removeItem(item.id) },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.trash),
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xffd4183d),
                        contentDescription = "Remover item"
                    )
                }
            }
        }
    }
}

@Composable
fun ItemCounter(
    count: Int,
    removeItem: () -> Unit,
    addItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedIconButton(
            onClick = removeItem,
            enabled = true,
            border = BorderStroke(1.dp, Color.Transparent),
            colors = IconButtonColors(
                Color(0xfffce4e9),
                Color(0xff000000),
                Color(0xfffce4e9),
                Color(0xfffce4e9)
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.remove),
                contentDescription = "Remover item",
                tint = Color.Black
            )
        }

        Text(
            text = "$count",
            modifier = modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedIconButton(
            onClick = addItem,
            border = BorderStroke(1.dp, Color.Transparent),
            colors = IconButtonColors(
                Color(0xfffce4e9),
                Color.Black,
                Color(0xfffce4e9),
                Color(0xfffce4e9)
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                tint = Color.Black,
                contentDescription = "Remover item"
            )
        }
    }
}