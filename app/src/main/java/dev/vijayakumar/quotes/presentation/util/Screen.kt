package dev.vijayakumar.quotes.presentation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector
){
    object Home: Screen("Home", Icons.Filled.Home, Icons.Outlined.Home)
    object QOD: Screen("Quote", Icons.Filled.Check, Icons.Outlined.Check)
    object Quotes: Screen("Quotes", Icons.Filled.Face, Icons.Outlined.Face)
    object Profile: Screen("Profile", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle)

}