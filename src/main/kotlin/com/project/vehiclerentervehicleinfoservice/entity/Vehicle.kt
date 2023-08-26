package com.project.vehiclerentervehicleinfoservice.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "vehicles")
open class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @NotNull
    @Column(name = "owner_id", nullable = false)
    open var ownerId: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    open var brand: Brand? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "model", nullable = false, length = 45)
    open var model: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "year", nullable = false, length = 45)
    open var year: String? = null

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    open var address: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "registration_number", nullable = false, length = 45)
    open var registrationNumber: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "color", nullable = false, length = 45)
    open var color: String? = null

    @NotNull
    @Column(name = "number_of_doors", nullable = false)
    open var numberOfDoors: Short? = null

    @NotNull
    @Column(name = "number_of_seats", nullable = false)
    open var numberOfSeats: Short? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "vehicle_type", nullable = false, length = 45)
    open var vehicleType: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "engine_type", nullable = false, length = 45)
    open var engineType: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "fuel_type", nullable = false, length = 45)
    open var fuelType: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "transmission_type", nullable = false, length = 45)
    open var transmissionType: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "vehicle_status", nullable = false, length = 45)
    open var vehicleStatus: String? = null

    @NotNull
    @Column(name = "price_per_day", nullable = false, precision = 11, scale = 2)
    open var pricePerDay: BigDecimal? = null

    @Size(max = 255)
    @Column(name = "image_link")
    open var imageLink: String? = null

    @NotNull
    @Column(name = "successful_rentals", nullable = false)
    open var successfulRentals: Int? = null

    @NotNull
    @Column(name = "unsuccessful_rentals", nullable = false)
    open var unsuccessfulRentals: Int? = null

    @Column(name = "last_requested_at")
    open var lastRequestedAt: Instant? = null

    @Column(name = "last_rented_at")
    open var lastRentedAt: Instant? = null

    @OneToMany(mappedBy = "vehicle")
    open var vehicleSettings: MutableSet<VehicleSetting> = mutableSetOf()
}