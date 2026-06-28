package com.example.artetoca

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
import androidx.lifecycle.viewmodel.compose.viewModel
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
import com.example.artetoca.Screen.Sobre
import com.example.artetoca.artesoes.Artesoes
import com.example.artetoca.carrinho.Carrinho
import com.example.artetoca.carrinho.CarrinhoViewModel
import com.example.artetoca.categorias.Produto
import com.example.artetoca.categorias.bordado
import com.example.artetoca.categorias.croche
import com.example.artetoca.categorias.macrame
import com.example.artetoca.categorias.palha
import com.example.artetoca.categorias.papel
import com.example.artetoca.categorias.pintura

data class NavItem(val label: String, val icon: Int, val screen: Screen)

val navItems = listOf(
    NavItem("Início", drawable.home_icon, Home),
    NavItem("Sobre", drawable.info_circle, Sobre),
    NavItem("Artesões", drawable.people, Artesoes),
    NavItem("Carrinho", drawable.shopping_cart, Carrinho)
)


@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ArtetocaApp() {
    val backStack = rememberNavBackStack(Home)
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()
    var selectedTab by remember { mutableIntStateOf(0) }
    val carrinhoViewModel: CarrinhoViewModel = viewModel()
    val adicionarAoCarrinho: (Produto) -> Unit = { produto ->
        carrinhoViewModel.adicionarItem(produto)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = {
                            selectedTab = index
                            backStack.add(item.screen)
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label
                            )
                        },
                        label = { Text(item.label) }
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
                entry<Bordado>(metadata = ListDetailSceneStrategy.detailPane()) {
                    bordado(onComprarClick = adicionarAoCarrinho)
                }
                entry<Croche>(metadata = ListDetailSceneStrategy.detailPane()) {
                    croche(onComprarClick = adicionarAoCarrinho)
                }
                entry<Pintura>(metadata = ListDetailSceneStrategy.detailPane()) {
                    pintura(onComprarClick = adicionarAoCarrinho)
                }
                entry<Papel>(metadata = ListDetailSceneStrategy.detailPane()) {
                    papel(onComprarClick = adicionarAoCarrinho)
                }
                entry<Palha>(metadata = ListDetailSceneStrategy.detailPane()) {
                    palha(onComprarClick = adicionarAoCarrinho)
                }
                entry<Macrame>(metadata = ListDetailSceneStrategy.detailPane()) {
                    macrame(onComprarClick = adicionarAoCarrinho)
                }
                entry<Artesoes> { Artesoes() }
                entry<Sobre> { sobre() }
                entry<Carrinho> {
                    Carrinho(viewModel = carrinhoViewModel, onExploreClick = {
                        backStack.clear()
                        backStack.add(Home)
                    })
                }
            }
        )
    }
}