package com.project.vehiclerentervehicleinfoservice.service

import com.project.vehiclerentervehicleinfoservice.dao.BrandDao
import com.project.vehiclerentervehicleinfoservice.mapper.BrandMapper
import org.springframework.stereotype.Service

@Service
class BrandService(val dao: BrandDao, private val brandMapper: BrandMapper) {

    fun getBrands() = dao.getBrands().map(brandMapper::toDto)
}