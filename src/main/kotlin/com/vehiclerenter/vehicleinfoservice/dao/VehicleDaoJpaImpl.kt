package com.vehiclerenter.vehicleinfoservice.dao

import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import com.vehiclerenter.vehicleinfoservice.repository.VehicleRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class VehicleDaoJpaImpl(val repository: VehicleRepository) : VehicleDao {

    override fun findAll(): List<Vehicle> = repository.findAllByDeletedFalse()

    override fun findById(id: UUID): Vehicle? = repository.findByIdAndDeletedFalse(id).unwrap()

    override fun save(vehicle: Vehicle): Vehicle = repository.save(vehicle)

    private fun <T> Optional<T>.unwrap(): T? = orElse(null)
}