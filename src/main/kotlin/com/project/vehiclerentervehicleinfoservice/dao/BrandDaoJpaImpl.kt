package com.project.vehiclerentervehicleinfoservice.dao

import com.project.vehiclerentervehicleinfoservice.entity.Brand
import com.project.vehiclerentervehicleinfoservice.repository.BrandRepository
import org.springframework.stereotype.Repository

@Repository
class BrandDaoJpaImpl(val repository: BrandRepository) :  BrandDao {

    override fun getBrands(): List<Brand> = repository.findAll()
}