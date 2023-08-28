package com.vehiclerenter.vehicleinfoservice.repository

import com.vehiclerenter.vehicleinfoservice.entity.VehicleSetting
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VehicleSettingRepository : JpaRepository<VehicleSetting, UUID>