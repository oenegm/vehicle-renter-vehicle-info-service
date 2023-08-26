package com.project.vehiclerentervehicleinfoservice.repository

import com.project.vehiclerentervehicleinfoservice.entity.VehicleSetting
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VehicleSettingRepository : JpaRepository<VehicleSetting, UUID>