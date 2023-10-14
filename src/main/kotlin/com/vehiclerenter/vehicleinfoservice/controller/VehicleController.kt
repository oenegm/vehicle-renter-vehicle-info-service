package com.vehiclerenter.vehicleinfoservice.controller

import com.vehiclerenter.vehicleinfoservice.dto.VehicleDto
import com.vehiclerenter.vehicleinfoservice.service.VehicleService
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/vehicles")
class VehicleController(val service: VehicleService) {

    @GetMapping
    fun getVehicles(
        @RequestHeader("Accept-Language", required = false, defaultValue = "ENGLISH") locale: Locale
    ): ResponseEntity<CollectionModel<VehicleDto>> {

        val vehicles: List<VehicleDto> = service.getAllVehicles()

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                CollectionModel
                    .of(vehicles)
                    .add(
                        linkTo<VehicleController> { getVehicles(locale) }.withSelfRel(),
                        linkTo<VehicleController> { getVehicleById(UUID.randomUUID(), locale) }.withSelfRel(),
                        // TODO: make sure this the correct way to put it
                        linkTo<BrandController> { getBrands(locale) }.withSelfRel(),
                    )
            )
    }

    @GetMapping("{vehicleId}")
    fun getVehicleById(
        @PathVariable("vehicleId") vehicleId: UUID,
        @RequestHeader("Accept-Language", required = false, defaultValue = "ENGLISH") locale: Locale,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicle: VehicleDto? = service.getVehicleById(vehicleId)

        return ResponseEntity.status(HttpStatus.OK)
            .body(
                RepresentationModel
                    .of(vehicle)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicleId, locale) }.withSelfRel(),
                        linkTo<BrandController> { getBrands(locale) }.withSelfRel()
                    )
            )
    }

    @PostMapping
    fun createVehicle(
        @RequestBody vehicleDto: VehicleDto,
        @RequestHeader("Accept-Language", required = false, defaultValue = "ENGLISH") locale: Locale,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicle = service.createVehicle(vehicleDto)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                RepresentationModel
                    .of(vehicle)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicle.id!!, locale) }.withSelfRel(),
                        linkTo<BrandController> { getBrands(locale) }.withSelfRel()
                    )
            )
    }

    @PutMapping("{vehicleId}")
    fun updateVehicle(
        @PathVariable("vehicleId") vehicleId: UUID,
        @RequestBody vehicleDto: VehicleDto,
        @RequestHeader("Accept-Language", required = false, defaultValue = "ENGLISH") locale: Locale,
    ): ResponseEntity<RepresentationModel<*>> {

        val vehicle: VehicleDto = service.updateVehicle(vehicleId, vehicleDto)

        return ResponseEntity.status(HttpStatus.OK)
            .body(
                RepresentationModel
                    .of(vehicle)
                    .add(
                        linkTo<VehicleController> { getVehicleById(vehicle.id!!, locale) }.withSelfRel(),
                        linkTo<BrandController> { getBrands(locale) }.withSelfRel()
                    )
            )
    }

    @DeleteMapping("{vehicleId}")
    fun deleteVehicleSoft(
        @PathVariable("vehicleId") vehicleId: UUID,
        @RequestHeader("Accept-Language", required = false, defaultValue = "ENGLISH") locale: Locale,
    ): ResponseEntity<RepresentationModel<*>> {

        service.deleteVehicleSoft(vehicleId)

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(
                RepresentationModel
                    .of(null)
                    .add(
                        linkTo<VehicleController> { getVehicles(locale) }.withSelfRel(),
                        linkTo<BrandController> { getBrands(locale) }.withSelfRel()
                    )
            )
    }
}
