package com.vehiclerenter.vehicleinfoservice.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import lombok.Data
import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant
import java.util.*

/**
 * DTO for {@link com.vehiclerenter.vehicleinfoservice.entity.Vehicle}
 */
@Data
class VehicleDto(
    var id: UUID? = null,
    @field:NotNull var ownerId: UUID? = null,
    var brandId: UUID? = null,
    var brandName: String? = null,
    var brandImageLink: String? = null,
    @field:NotNull @field:Size(max = 45) var model: String? = null,
    @field:NotNull @field:Size(max = 45) var year: String? = null,
    @field:NotNull @field:Size(max = 255) var address: String? = null,
    @field:NotNull @field:Size(max = 45) var registrationNumber: String? = null,
    @field:NotNull @field:Size(max = 45) var color: String? = null,
    @field:NotNull var numberOfDoors: Short? = null,
    @field:NotNull var numberOfSeats: Short? = null,
    @field:NotNull @field:Size(max = 45) var vehicleType: String? = null,
    @field:NotNull @field:Size(max = 45) var engineType: String? = null,
    @field:NotNull @field:Size(max = 45) var fuelType: String? = null,
    @field:NotNull @field:Size(max = 45) var transmissionType: String? = null,
    @field:NotNull @field:Size(max = 45) var vehicleStatus: String? = null,
    @field:NotNull var pricePerDay: BigDecimal? = null,
    @field:Size(max = 255) var imageLink: String? = null,
    @field:NotNull var successfulRentals: Int? = null,
    @field:NotNull var unsuccessfulRentals: Int? = null,
    var lastRequestedAt: Instant? = null,
    var lastRentedAt: Instant? = null,
    var vehicleSettingsId: UUID? = null,
    var vehicleSettingsIsVisible: Boolean? = false,
    var vehicleSettingsIsOutOfOrder: Boolean? = false,
) : Serializable