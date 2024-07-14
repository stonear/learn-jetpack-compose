package com.example.hellojetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.BackHand
import androidx.compose.material.icons.outlined.PhoneIphone
import androidx.compose.ui.graphics.vector.ImageVector

data class Menu(
    val name: String,
    val icon: ImageVector,
)

val menus = listOf(
    Menu("Semua Menu", Icons.Outlined.Apps),
    Menu("Transfer", Icons.Outlined.AttachMoney),
    Menu("Topup e-Wallet", Icons.Outlined.AccountBalanceWallet),
    Menu("Pulsa", Icons.Outlined.PhoneIphone),
    Menu("Tarik Tunai", Icons.Outlined.BackHand),
)
