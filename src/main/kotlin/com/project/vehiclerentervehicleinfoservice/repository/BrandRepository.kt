package com.project.vehiclerentervehicleinfoservice.repository

import com.project.vehiclerentervehicleinfoservice.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BrandRepository : JpaRepository<Brand, UUID>