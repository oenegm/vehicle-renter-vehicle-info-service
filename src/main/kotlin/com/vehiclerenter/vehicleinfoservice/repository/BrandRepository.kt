package com.vehiclerenter.vehicleinfoservice.repository

import com.vehiclerenter.vehicleinfoservice.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BrandRepository : JpaRepository<Brand, UUID>