package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import com.vehiclerenter.vehicleinfoservice.repository.VehicleRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class VehicleDaoJpaImpl(val repository: VehicleRepository) : VehicleDao {

    override fun save(vehicle: Vehicle): Vehicle = repository.save(vehicle)

    override fun getVehicles(): List<Vehicle> = repository.findAll()

    override fun findById(id: UUID): Vehicle? = repository.findById(id).unwrap()

    private fun <T> Optional<T>.unwrap(): T? = orElse(null)
}