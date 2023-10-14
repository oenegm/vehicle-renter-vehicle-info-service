package com.vehiclerenter.vehicleinfoservice.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant
import java.util.*

/**
 * DTO for {@link com.vehiclerenter.vehicleinfoservice.entity.Vehicle}
 */
data class VehicleDto(
    val id: UUID? = null,
    @field:NotNull val ownerId: UUID? = null,
    val brandId: UUID? = null,
    val brandName: String? = null,
    val brandImageLink: String? = null,
    @field:NotNull @field:Size(max = 45) val model: String? = null,
    @field:NotNull @field:Size(max = 45) val year: String? = null,
    @field:NotNull @field:Size(max = 255) val address: String? = null,
    @field:NotNull @field:Size(max = 45) val registrationNumber: String? = null,
    @field:NotNull @field:Size(max = 45) val color: String? = null,
    @field:NotNull val numberOfDoors: Short? = null,
    @field:NotNull val numberOfSeats: Short? = null,
    @field:NotNull @field:Size(max = 45) val vehicleType: String? = null,
    @field:NotNull @field:Size(max = 45) val engineType: String? = null,
    @field:NotNull @field:Size(max = 45) val fuelType: String? = null,
    @field:NotNull @field:Size(max = 45) val transmissionType: String? = null,
    @field:NotNull @field:Size(max = 45) val vehicleStatus: String? = null,
    @field:NotNull val pricePerDay: BigDecimal? = null,
    @field:Size(max = 255) val imageLink: String? = null,
    @field:NotNull val successfulRentals: Int? = null,
    @field:NotNull val unsuccessfulRentals: Int? = null,
    val lastRequestedAt: Instant? = null,
    val lastRentedAt: Instant? = null,
    val vehicleSettingsId: UUID? = null,
    val vehicleSettingsIsVisible: Boolean? = false,
    val vehicleSettingsIsOutOfOrder: Boolean? = false
) : Serializable