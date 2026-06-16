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
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artetoca.ui.theme.ArtetocaTheme
import kotlinx.coroutines.launch

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
    Pair("Artesoes",R.drawable.people),
    Pair("Cart", R.drawable.shopping_cart)
)

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ArtetocaApp() {
    val navigator = rememberListDetailPaneScaffoldNavigator<String>()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEach { (label, icon) ->
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(id = icon),
                                contentDescription = null
                            )
                        },
                        label = { Text(label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavigableListDetailPaneScaffold(
            modifier = Modifier.padding(innerPadding),
            navigator = navigator,
            listPane = {
                PaginaInicial(
                    modifier = Modifier.fillMaxWidth(),
                    onCategoriaClick = { categoriaNome ->
                        coroutineScope.launch {
                            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, categoriaNome)
                        }
                    }
                )
            },
            detailPane = {
                Text("")
            }
        )
    }
}

@Preview
@Composable
fun ArtetocaPreview() {
    ArtetocaApp()
}