package com.vehiclerenter.vehicleinfoservice.repository

import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VehicleSettingsRepository : JpaRepository<VehicleSettings, UUID> {

    fun findByVehicleId(vehicleId: UUID): Optional<VehicleSettings>
}