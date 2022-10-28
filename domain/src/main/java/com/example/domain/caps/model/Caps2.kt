package com.example.domain.caps.model

data class Caps2(
    val id : Int,
    val name: String,
    val image: String,
    val description: String,
    val price: Number,
    val created: String,
    val updated: String,
    val new_price : Number,
    val brand: Int,
    val size: ArrayList<Int>
    )