package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import java.util.*

interface VehicleDao {

    fun findAll(): List<Vehicle>

    fun findById(id: UUID): Vehicle?

    fun save(vehicle: Vehicle): Vehicle

    fun delete(vehicle: Vehicle)
}