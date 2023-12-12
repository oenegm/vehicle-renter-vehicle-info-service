package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dao.VehicleDao
import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import java.util.*

@Service
@Primary
class VehicleService(private val dao: VehicleDao, private val settingsService: VehicleSettingsService) {

    fun getAllVehicles(): List<VehicleDto> = dao.findAll().map { it.toDto() }

    fun getVehicleById(vehicleId: UUID): VehicleDto? {

        val vehicle = dao.findById(vehicleId)
            ?: throw RuntimeException("Vehicle with id $vehicleId not found")

        return vehicle.toDto()
    }

    fun createVehicle(vehicleDto: VehicleDto): VehicleDto {

        var vehicle = vehicleDto.toEntity()

        vehicle = dao.save(vehicle)

        settingsService.createVehicleSettings(vehicle)

        return vehicle.toDto()
    }

    fun updateVehicle(vehicleId: UUID, vehicleDto: VehicleDto): VehicleDto {

        var vehicle = dao.findById(vehicleId)
            ?: throw RuntimeException("Vehicle with id $vehicleId not found")

        vehicle.partialUpdate(vehicleDto)

        vehicle = dao.save(vehicle)

        return vehicle.toDto()
    }

    fun deleteVehicleSoft(vehicleId: UUID) {

        val vehicle = dao.findById(vehicleId)
            ?: throw RuntimeException("Vehicle with id $vehicleId not found")

        dao.delete(vehicle)
    }
}