package com.example.artetoca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import com.example.artetoca.artesoes.Artesoes
import com.example.artetoca.carrinho.Carrinho
import com.example.artetoca.ui.theme.ArtetocaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtetocaTheme {
                ArtetocaApp()
            }
        }
    }
}

val navItems = listOf(
    Pair("Home", R.drawable.home_icon),
    Pair("Info", R.drawable.info_circle),
    Pair("Artesoes", R.drawable.people),
    Pair("Cart", R.drawable.shopping_cart)
)

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ArtetocaApp() {
    val backStack = rememberNavBackStack(Screen.Home)
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, (label, icon) ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = {
                            selectedTab = index
                            when (index) {
                                0 -> backStack.add(Screen.Home)
                                2 -> backStack.add(Screen.Artesoes)
                                3 -> backStack.add(Screen.Carrinho)
                            }
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = icon),
                                contentDescription = label
                            )
                        },
                        label = { Text(label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = backStack,
            sceneStrategy = listDetailStrategy,
            entryDecorators = listOf(
                rememberViewModelStoreNavEntryDecorator()
            ),
            onBack = { if (backStack.size > 1) backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Screen.Home>(
                    metadata = ListDetailSceneStrategy.listPane(
                        detailPlaceholder = { Text("Selecione uma categoria") }
                    )
                ) {
                    PaginaInicial(
                        modifier = Modifier.fillMaxWidth(),
                        onCategoriaClick = { nome ->
                            when (nome) {
                                "Bordado" -> backStack.add(Screen.Bordado)
                                "Crochê", "Croche" -> backStack.add(Screen.Croche)
                                "Pinturas" -> backStack.add(Screen.Pintura)
                                "Papel Machê" -> backStack.add(Screen.Papel)
                                "Palha" -> backStack.add(Screen.Palha)
                                "Macramê", "Macrame" -> backStack.add(Screen.Macrame)
                                else -> Unit
                            }
                        }
                    )
                }
                entry<Screen.Bordado>(metadata = ListDetailSceneStrategy.detailPane()) { bordado() }
                entry<Screen.Croche>(metadata = ListDetailSceneStrategy.detailPane()) { croche() }
                entry<Screen.Pintura>(metadata = ListDetailSceneStrategy.detailPane()) { pintura() }
                entry<Screen.Papel>(metadata = ListDetailSceneStrategy.detailPane()) { papel() }
                entry<Screen.Palha>(metadata = ListDetailSceneStrategy.detailPane()) { palha() }
                entry<Screen.Macrame>(metadata = ListDetailSceneStrategy.detailPane()) { macrame() }
                entry<Screen.Artesoes> { Artesoes() }
                entry<Screen.Carrinho> { Carrinho() }
            }
        )
    }
}