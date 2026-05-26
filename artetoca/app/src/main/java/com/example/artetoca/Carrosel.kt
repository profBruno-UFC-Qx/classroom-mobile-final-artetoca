package com.example.artetoca

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class CarouselItem(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val subtitle: String,
    val badge: String? = null,           // e.g. "NOVO", "OFERTA"
    val badgeColor: Color = Color(0xFFFF3B30),
    val accentColor: Color = Color(0xFF007AFF),
)

val sampleItems = listOf(
    CarouselItem(
        id = 1,
        imageUrl = "https://picsum.photos/seed/app1/800/400",
        title = "App do Mês",
        subtitle = "Descubra a experiência que está transformando o jeito de trabalhar",
        badge = "DESTAQUE",
        badgeColor = Color(0xFF34C759),
        accentColor = Color(0xFF007AFF),
    ),
    CarouselItem(
        id = 2,
        imageUrl = "https://picsum.photos/seed/app2/800/400",
        title = "Jogo da Semana",
        subtitle = "Aventura épica em mundo aberto — gratuito por tempo limitado",
        badge = "GRÁTIS",
        badgeColor = Color(0xFFFF9500),
        accentColor = Color(0xFFFF2D55),
    ),
    CarouselItem(
        id = 3,
        imageUrl = "https://picsum.photos/seed/app3/800/400",
        title = "Produtividade",
        subtitle = "As melhores ferramentas para organizar sua vida em um só lugar",
        badge = "NOVO",
        badgeColor = Color(0xFFAF52DE),
        accentColor = Color(0xFF5856D6),
    ),
    CarouselItem(
        id = 4,
        imageUrl = "https://picsum.photos/seed/app4/800/400",
        title = "Saúde & Bem-estar",
        subtitle = "Cuide do seu corpo e mente com apps recomendados por especialistas",
        accentColor = Color(0xFF30B0C7),
    ),
)

@Composable
private fun CarouselCard(
    item: CarouselItem,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .width(width)
            .height(height)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Box {
            // Background image
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )

            // Gradient overlay (bottom-to-top dark scrim)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.15f),
                                Color.Black.copy(alpha = 0.72f),
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY,
                        )
                    )
            )

            // Badge
            if (item.badge != null) {
                Box(
                    modifier = Modifier
                        .padding(14.dp)
                        .align(Alignment.TopStart)
                        .clip(RoundedCornerShape(6.dp))
                        .background(item.badgeColor)
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                ) {
                    Text(
                        text = item.badge,
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.8.sp,
                    )
                }
            }

            // Text block (bottom)
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(horizontal = 18.dp, vertical = 16.dp),
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = item.subtitle,
                    color = Color.White.copy(alpha = 0.82f),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp,
                )
            }

            // Thin colored accent line at bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .align(Alignment.BottomCenter)
                    .background(item.accentColor),
            )
        }
    }
}

@Composable
fun StoreImageCarousel(
    items: List<CarouselItem>,
    modifier: Modifier = Modifier,
    cardWidth: Dp? = null,
    cardHeight: Dp = 220.dp,
    onItemClick: (CarouselItem) -> Unit = {},
    autoScroll: Boolean = true,
    autoScrollDelayMs: Long = 4_000L,
) {
    if (items.isEmpty()) return

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Track which item is "center" based on scroll offset
    val currentIndex by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex
        }
    }

    // Auto-scroll logic
    if (autoScroll) {
        LaunchedEffect(currentIndex) {
            delay(autoScrollDelayMs)
            val next = (currentIndex + 1) % items.size
            coroutineScope.launch {
                listState.animateScrollToItem(next)
            }
        }
    }

    Column(modifier = modifier) {
        // ── Card row ──────────────────────────────────────────
        BoxWithConstraints {
            val resolvedCardWidth = cardWidth ?: (maxWidth * 0.88f)
            val horizontalPadding = (maxWidth - resolvedCardWidth) / 2

            LazyRow(
                state = listState,
                contentPadding = PaddingValues(horizontal = horizontalPadding),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                items(items.size) { index ->
                    val item = items[index]

                    // Scale animation: center card is full-size, others slightly shrunk
                    val isCurrent = index == currentIndex
                    val scale by animateFloatAsState(
                        targetValue = if (isCurrent) 1f else 0.94f,
                        animationSpec = tween(300),
                        label = "cardScale",
                    )

                    CarouselCard(
                        item = item,
                        width = resolvedCardWidth,
                        height = cardHeight,
                        modifier = Modifier.scale(scale),
                        onClick = { onItemClick(item) },
                    )
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        // ── Page indicators ───────────────────────────────────
        PageIndicator(
            count = items.size,
            current = currentIndex,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onDotClick = { index ->
                coroutineScope.launch {
                    listState.animateScrollToItem(index)
                }
            },
        )
    }
}

@Composable
private fun PageIndicator(
    count: Int,
    current: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    inactiveColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.25f),
    onDotClick: (Int) -> Unit = {},
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(count) { index ->
            val isActive = index == current

            val width by animateDpAsState(
                targetValue = if (isActive) 20.dp else 6.dp,
                animationSpec = tween(300),
                label = "dotWidth",
            )
            val color by animateFloatAsState(
                targetValue = if (isActive) 1f else 0f,
                animationSpec = tween(300),
                label = "dotColor",
            )

            Box(
                modifier = Modifier
                    .height(6.dp)
                    .width(width)
                    .clip(CircleShape)
                    .background(
                        if (isActive) activeColor else inactiveColor
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) { onDotClick(index) },
            )
        }
    }
}