package com.vehiclerenter.vehicleinfoservice.service

import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import java.util.*

interface VehicleService {

    fun getAllVehicles(): List<VehicleDto>
    fun getVehicleById(vehicleId: UUID): VehicleDto?
    fun createVehicle(vehicleDto: VehicleDto): VehicleDto
    fun updateVehicle(vehicleId: UUID, vehicleDto: VehicleDto): VehicleDto
    fun deleteVehicleSoft(vehicleId: UUID)
}