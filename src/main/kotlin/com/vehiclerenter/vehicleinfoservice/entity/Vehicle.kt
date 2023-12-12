package com.vehiclerenter.vehicleinfoservice.entity

import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "vehicles")
class Vehicle(
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: UUID? = null,

    @NotNull
    @Column(name = "owner_id", nullable = false)
    var ownerId: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    var brand: Brand,

    @OneToOne(mappedBy = "vehicle")
    var vehicleSettings: VehicleSettings? = null,

    @Size(max = 45)
    @Column(name = "model", length = 45)
    var model: String? = null,

    @Size(max = 45)
    @Column(name = "year", length = 45)
    var year: String? = null,

    @Size(max = 255)
    @Column(name = "address")
    var address: String? = null,

    @Size(max = 45)
    @Column(name = "color", length = 45)
    var color: String? = null,

    @Column(name = "number_of_doors", nullable = false)
    var numberOfDoors: Short? = null,

    @Column(name = "number_of_seats", nullable = false)
    var numberOfSeats: Short? = null,

    @Size(max = 45)
    @Column(name = "vehicle_status", length = 45)
    var vehicleStatus: String? = null,

    @Column(name = "price_per_day", precision = 11, scale = 2)
    var pricePerDay: BigDecimal? = null,

    @Size(max = 255)
    @Column(name = "image_link")
    var imageLink: String? = null,

    @Column(name = "successful_rentals")
    var successfulRentals: Int? = null,

    @Column(name = "unsuccessful_rentals", nullable = false)
    var unsuccessfulRentals: Int? = null,

    @Column(name = "last_requested_at")
    var lastRequestedAt: LocalDateTime? = null,

    @Column(name = "last_rented_at")
    var lastRentedAt: LocalDateTime? = null,
) {
    fun toDto() = VehicleDto(
        id = this.id,
        ownerId = this.ownerId,
        brand = this.brand.toDto(),
        vehicleSettings = this.vehicleSettings?.toDto(),
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

    fun partialUpdate(dto: VehicleDto): Vehicle {

        this.model = dto.model ?: this.model
        this.year = dto.year ?: this.year
        this.address = dto.address ?: this.address
        this.color = dto.color ?: this.color
        this.numberOfDoors = dto.numberOfDoors ?: this.numberOfDoors
        this.numberOfSeats = dto.numberOfSeats ?: this.numberOfSeats
        this.pricePerDay = dto.pricePerDay ?: this.pricePerDay

        return this
    }
}
