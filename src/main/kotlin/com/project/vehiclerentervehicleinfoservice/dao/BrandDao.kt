package com.project.vehiclerentervehicleinfoservice.dao

import com.project.vehiclerentervehicleinfoservice.entity.Brand
import com.project.vehiclerentervehicleinfoservice.repository.BrandRepository
import org.springframework.stereotype.Repository

@Repository
class BrandDao(val repository: BrandRepository) {

    fun getBrands(): List<Brand> = repository.findAll()
}