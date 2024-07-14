package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.CurrencyExchange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.CardGiftcard
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.AsyncImage
import com.example.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // hide system bars
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        // Configure the behavior of the hidden system bars.
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())

        enableEdgeToEdge(

        )
        setContent {
            Home()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Home() {
    HelloJetpackComposeTheme(
        darkTheme = false, dynamicColor = false
    ) {
        Box(
            modifier = Modifier
//                .safeDrawingPadding()
                .fillMaxSize()

        ) {
            Card(
                shape = RoundedCornerShape(
                    topEnd = 0.dp, topStart = 0.dp, bottomEnd = 10.dp, bottomStart = 10.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                colors = CardDefaults.cardColors().copy(
                    containerColor = Color.LightGray
                )
            ) {}
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
                topBar = {
                    HomeTopBar()
                },
                content = { padding ->
                    Column(
                        modifier = Modifier.padding(padding)
                    ) {
                        HomeContent()
                    }
                },
                bottomBar = {
                    HomeBottomBar()
                },
                floatingActionButton = {
                    QRISBar()
                },
                floatingActionButtonPosition = FabPosition.Center,
                containerColor = Color.Transparent,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .padding(
                all = 20.dp
            )
            .height(50.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .height(54.dp)
                .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
            painter = painterResource(id = R.drawable.logo_white),
            contentDescription = stringResource(id = R.string.logo)
        )
        VerticalDivider(
            color = Color.Black, modifier = Modifier
                .height(24.dp)
                .width(1.dp)
        )
        Text(text = "Personal")
        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
        Spacer(Modifier.weight(1f))
        Icon(Icons.Default.Notifications, contentDescription = "")
        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContent() {
    Column(
        modifier = Modifier.padding(
            all = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(text = "Selamat Malam, Ilham God", fontWeight = FontWeight.Bold)
        Card(
            modifier = Modifier.fillMaxWidth(),
//                .height(100.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            ),
        ) {
            Column(
                modifier = Modifier.padding(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(text = "Total Saldo")
                    Text(
                        text = "Rp 999.999....", fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.weight(1f))
                    Text(text = "Lihat 9 Saku")
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                    ) {
                        Column(
                            modifier = Modifier.padding(6.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(3.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    Icons.Rounded.AccountBalance,
                                    contentDescription = "",
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "Saku Utama",
                                    fontSize = 12.sp,
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(3.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Rp • • • • •",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Icon(
                                    Icons.Outlined.RemoveRedEye,
                                    contentDescription = "",
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.width(90.dp),
                        shape = RoundedCornerShape(6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                    ) {
                        Column(
                            modifier = Modifier.padding(6.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(3.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    Icons.Rounded.CardGiftcard,
                                    contentDescription = "",
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "Rewards",
                                    fontSize = 12.sp,
                                )
                            }
                            Text(
                                text = "Cek di sini", fontSize = 12.sp, fontWeight = FontWeight.Bold
                            )
                        }

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow {
            items(menus) { menu ->
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(all = 3.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = MaterialTheme.colorScheme.surfaceVariant)
                            .padding(11.dp)
                    ) {
                        Icon(
                            menu.icon, contentDescription = "", modifier = Modifier.size(27.dp)

                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = menu.name)
                }
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .height(6.dp)
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .width(40.dp)
                .height(6.dp)
                .background(
                    color = Color.LightGray, shape = RoundedCornerShape(
                        15.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .width(24.dp)
                    .height(6.dp)
                    .background(
                        color = Color.DarkGray, shape = RoundedCornerShape(
                            15.dp
                        )
                    )
                    .offset(x = (-8).dp)
            )
        }
    }
    Spacer(
        modifier = Modifier
            .height(15.dp)
            .fillMaxWidth()
    )
    Spacer(
        modifier = Modifier
            .height(5.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray)
    )
    Column(
        modifier = Modifier.padding(
            all = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Info & Promo Spesial", fontWeight = FontWeight.Bold)
            Text(text = "Lihat Semua")
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(promos) { promo ->
                AsyncImage(
                    modifier = Modifier
                        .height(126.dp)
                        .width(244.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    model = promo.link,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
                )
            }
        }
    }
    Spacer(
        modifier = Modifier
            .height(5.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray)
    )
    Column(
        modifier = Modifier.padding(
            all = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.weight(1f))
            Icon(
                Icons.AutoMirrored.Outlined.HelpOutline,
                contentDescription = "",
                modifier = Modifier.size(27.dp)
            )
            Text(text = "Butuh Bantuan?")
            Text(
                text = "Hubungi Gustov", fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBottomBar() {
    Card(
        shape = RoundedCornerShape(
            topEnd = 10.dp, topStart = 10.dp, bottomEnd = 0.dp, bottomStart = 0.dp
        ),
        modifier = Modifier.fillMaxWidth(),
//            .semiBorder(
//                1.dp,
//                Color.Black,
//                10.dp,
//            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Outlined.Home, contentDescription = "", modifier = Modifier.size(27.dp)
                )
                Text(text = "Beranda")
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Outlined.CurrencyExchange,
                    contentDescription = "",
                    modifier = Modifier.size(27.dp)
                )
                Text(text = "Simpanan")
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier.height(27.dp)
                )
                Text(text = "Bayar")
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Outlined.CreditCard,
                    contentDescription = "",
                    modifier = Modifier.size(27.dp)
                )
                Text(text = "Kartu")
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Outlined.AccountCircle,
                    contentDescription = "",
                    modifier = Modifier.size(27.dp)
                )
                Text(text = "Akun")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QRISBar() {
    Box(
        modifier = Modifier
            .offset(y = 50.dp)
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = Color.DarkGray)
                .padding(all = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Outlined.QrCode,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) = if (LocalInspectionMode.current) {
    painterResource(id = debugPreview)
} else {
    null
}

