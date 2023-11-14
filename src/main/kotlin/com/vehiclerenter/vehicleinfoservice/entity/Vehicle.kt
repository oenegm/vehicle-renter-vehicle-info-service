package com.vehiclerenter.vehicleinfoservice.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "vehicles")
class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: UUID? = null

    @NotNull
    @Column(name = "owner_id", nullable = false)
    lateinit var ownerId: UUID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    var brand: Brand? = null

    @OneToOne(mappedBy = "vehicle")
    var vehicleSettings: VehicleSettings? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "model", length = 45)
    var model: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "year", length = 45)
    var year: String? = null

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    var address: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "registration_number", nullable = false, length = 45)
    var registrationNumber: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "color", nullable = false, length = 45)
    var color: String? = null

    @NotNull
    @Column(name = "number_of_doors", nullable = false)
    var numberOfDoors: Short? = null

    @NotNull
    @Column(name = "number_of_seats", nullable = false)
    var numberOfSeats: Short? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "vehicle_status", nullable = false, length = 45)
    var vehicleStatus: String? = null

    @NotNull
    @Column(name = "price_per_day", nullable = false, precision = 11, scale = 2)
    var pricePerDay: BigDecimal? = null

    @Size(max = 255)
    @Column(name = "image_link")
    var imageLink: String? = null

    @NotNull
    @Column(name = "successful_rentals", nullable = false)
    var successfulRentals: Int? = null

    @NotNull
    @Column(name = "unsuccessful_rentals", nullable = false)
    var unsuccessfulRentals: Int? = null

    @Column(name = "last_requested_at")
    var lastRequestedAt: LocalDateTime? = null

    @Column(name = "last_rented_at")
    var lastRentedAt: LocalDateTime? = null

    @Column(name = "deleted")
    var deleted: Boolean = false
}
