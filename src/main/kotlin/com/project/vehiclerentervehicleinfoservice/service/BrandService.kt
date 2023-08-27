package com.project.vehiclerentervehicleinfoservice.service

import com.project.vehiclerentervehicleinfoservice.dto.BrandDto

fun interface BrandService {
    fun getBrands(): List<BrandDto>
}