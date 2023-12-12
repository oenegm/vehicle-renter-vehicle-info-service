package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.VehicleSettingsDao
import com.vehiclerenter.vehicleinfoservice.dto.VehicleSettingsDto
import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import com.vehiclerenter.vehicleinfoservice.entity.VehicleSettings
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import java.util.*

@Service
@Primary
class VehicleSettingsService(private val dao: VehicleSettingsDao) {

    fun createVehicleSettings(vehicle: Vehicle) {

        val vehicleSettings = VehicleSettings(
            vehicle = vehicle,
            visible = true,
            outOfService = false,
        )

        dao.save(vehicleSettings)
    }

    fun updateVehicleSettings(vehicleId: UUID, settingsDto: VehicleSettingsDto): VehicleSettingsDto {
        var vehicleSettings = dao.findByVehicleId(vehicleId)
            ?: throw RuntimeException("Vehicle with id $vehicleId not found")

        vehicleSettings = vehicleSettings.partialUpdate(settingsDto)

        return dao.save(vehicleSettings).toDto()
    }
}