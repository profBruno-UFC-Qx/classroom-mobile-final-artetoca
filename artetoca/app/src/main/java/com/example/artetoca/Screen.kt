package com.example.artetoca

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey {
    @Serializable data object Home : Screen
    @Serializable data object Bordado : Screen
    @Serializable data object Croche : Screen
    @Serializable data object Pintura : Screen
    @Serializable data object Papel : Screen
    @Serializable data object Palha : Screen
    @Serializable data object Macrame : Screen
    @Serializable data object Sobre : Screen
    @Serializable data object Artesoes : Screen
    @Serializable data object Carrinho : Screen
}