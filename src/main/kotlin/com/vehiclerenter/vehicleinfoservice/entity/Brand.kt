package com.vehiclerenter.vehicleinfoservice.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.*

@Entity
@Table(name = "brands")
open class Brand {
    @Id
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    open var name: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "country", nullable = false, length = 45)
    open var country: String? = null

    @Size(max = 255)
    @NotNull
    @Column(name = "image_link", nullable = false)
    open var imageLink: String? = null

    @OneToMany(mappedBy = "brand")
    open var vehicles: MutableSet<Vehicle> = mutableSetOf()


}