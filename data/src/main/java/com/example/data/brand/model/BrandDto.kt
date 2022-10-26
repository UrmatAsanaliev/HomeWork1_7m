package com.example.data.brand.model

import com.example.domain.brand.model.Brand

data class BrandDto(

    val id: Int,
    val name: String,
    val image: String
)
fun BrandDto.toBrand(): Brand {
    return Brand(
        id = id,
        name = name,
        image = image
    )
}