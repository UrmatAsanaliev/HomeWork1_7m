package com.example.data.brand.model

import com.example.domain.brand.model.Brand
import com.example.domain.brand.model.BrandById

data class BrandByIdDto(
    val id : Int,
    val name: String,
    val image: String,
    val description: String,
    val price: Number,
    val created: String,
    val updated: String,
    val new_price: Number,
    val brand: Int,
    val size: ArrayList<Int>
)
fun BrandByIdDto.toBrandById(): BrandById {
    return BrandById(
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