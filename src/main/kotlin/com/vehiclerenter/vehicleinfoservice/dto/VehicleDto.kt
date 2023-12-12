package com.vehiclerenter.vehicleinfoservice.dto

import com.vehiclerenter.vehicleinfoservice.entity.Brand
import com.vehiclerenter.vehicleinfoservice.entity.Vehicle
import jakarta.validation.constraints.Size
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

/**
 * DTO for {@link com.vehiclerenter.vehicleinfoservice.entity.Vehicle}
 */
data class VehicleDto(
    var id: UUID? = null,
    var ownerId: UUID,
    var brand: BrandDto,
    var vehicleSettings: VehicleSettingsDto?,
    @field:Size(max = 45) var model: String? = null,
    @field:Size(max = 45) var year: String? = null,
    @field:Size(max = 255) var address: String? = null,
    @field:Size(max = 45) var color: String? = null,
    var numberOfDoors: Short? = null,
    var numberOfSeats: Short? = null,
    @field:Size(max = 45) var vehicleStatus: String? = null,
    var pricePerDay: BigDecimal? = null,
    @field:Size(max = 255) var imageLink: String? = null,
    var successfulRentals: Int? = null,
    var unsuccessfulRentals: Int? = null,
    var lastRequestedAt: LocalDateTime? = null,
    var lastRentedAt: LocalDateTime? = null
) : Serializable {
    fun toEntity() = Vehicle(
        ownerId = this.ownerId,
        brand = Brand(id = this.brand.id),
        model = this.model,
        year = this.year,
        address = this.address,
        color = this.color,
        numberOfDoors = this.numberOfDoors,
        numberOfSeats = this.numberOfSeats,
        vehicleStatus = this.vehicleStatus,
        pricePerDay = this.pricePerDay,
        imageLink = this.imageLink,
        successfulRentals = this.successfulRentals,
        unsuccessfulRentals = this.unsuccessfulRentals,
        lastRequestedAt = this.lastRequestedAt,
        lastRentedAt = this.lastRentedAt,
    )
}