package com.example.hellojetpackcompose

data class Promo(
    val link: String,
)

val promos = listOf(
    Promo("https://picsum.photos/244/126?grayscale&random=1"),
    Promo("https://picsum.photos/244/126?grayscale&random=2"),
    Promo("https://picsum.photos/244/126?grayscale&random=3"),
)
