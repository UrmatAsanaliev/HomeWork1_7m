package com.example.data.caps.model

import com.example.domain.caps.model.Caps

data class CapsDto(
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
fun CapsDto.toCaps() : Caps {
    return Caps(
        id = id,
        name = name,
        image = image,
        description = description,
        price = price,
        created = created,
        updated = updated,
        new_price = new_price,
        brand = brand,
        size = size
    )
}