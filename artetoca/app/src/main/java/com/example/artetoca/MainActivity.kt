package com.example.artetoca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.InternalFoundationApi
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
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.artetoca.R.drawable
import com.example.artetoca.Screen.Artesoes
import com.example.artetoca.Screen.Bordado
import com.example.artetoca.Screen.Carrinho
import com.example.artetoca.Screen.Croche
import com.example.artetoca.Screen.Home
import com.example.artetoca.Screen.Macrame
import com.example.artetoca.Screen.Palha
import com.example.artetoca.Screen.Papel
import com.example.artetoca.Screen.Pintura
import com.example.artetoca.artesoes.Artesoes
import com.example.artetoca.Screen.Sobre
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
    Pair("Home", drawable.home_icon),
    Pair("Sobre", drawable.info_circle),
    Pair("Artesoes", drawable.people),
    Pair("Cart", drawable.shopping_cart)
)

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ArtetocaApp() {
    val backStack = rememberNavBackStack(Home)
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
                                0 -> backStack.add(Home)
                                1 -> backStack.add(Sobre)
                                2 -> backStack.add(Artesoes)
                                3 -> backStack.add(Carrinho)
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
            sceneStrategies = listOf(listDetailStrategy),
            entryDecorators = listOf(
                rememberViewModelStoreNavEntryDecorator()
            ),
            onBack = { if (backStack.size > 1) backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Home>(
                    metadata = ListDetailSceneStrategy.listPane(
                        detailPlaceholder = { Text("Selecione uma categoria") }
                    )
                ) {
                    PaginaInicial(
                        modifier = Modifier.fillMaxWidth(),
                        onCategoriaClick = { nome ->
                            when (nome) {
                                "Bordado" -> backStack.add(Bordado)
                                "Crochê", "Croche" -> backStack.add(Croche)
                                "Pinturas" -> backStack.add(Pintura)
                                "Papel Machê" -> backStack.add(Papel)
                                "Palha" -> backStack.add(Palha)
                                "Macramê", "Macrame" -> backStack.add(Macrame)
                                else -> Unit
                            }
                        }
                    )
                }
                entry<Bordado>(metadata = ListDetailSceneStrategy.detailPane()) { bordado() }
                entry<Croche>(metadata = ListDetailSceneStrategy.detailPane()) { croche() }
                entry<Pintura>(metadata = ListDetailSceneStrategy.detailPane()) { pintura() }
                entry<Papel>(metadata = ListDetailSceneStrategy.detailPane()) { papel() }
                entry<Palha>(metadata = ListDetailSceneStrategy.detailPane()) { palha() }
                entry<Macrame>(metadata = ListDetailSceneStrategy.detailPane()) { macrame() }
                entry<Sobre> { sobre() }
                entry<Artesoes> { Artesoes() }
                entry<Carrinho> { Carrinho() }
            }
        )
    }
}