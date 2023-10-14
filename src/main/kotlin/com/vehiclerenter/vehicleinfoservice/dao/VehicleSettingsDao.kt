package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import java.util.*

interface VehicleSettingsDao {

    fun findById(id: UUID): VehicleSettings?

    fun findByVehicleId(vehicleId: UUID): VehicleSettings?
}