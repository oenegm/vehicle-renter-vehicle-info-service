package com.project.vehiclerentervehicleinfoservice.dao

import com.project.vehiclerentervehicleinfoservice.entity.Brand


fun interface BrandDao {
    fun getBrands(): List<Brand>
}