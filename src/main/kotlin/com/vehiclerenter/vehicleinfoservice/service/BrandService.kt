package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dto.BrandDto

fun interface BrandService {
    fun getBrands(): List<BrandDto>
}