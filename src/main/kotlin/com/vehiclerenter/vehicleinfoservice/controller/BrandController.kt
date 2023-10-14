package com.vehiclerenter.vehicleinfoservice.controller

import com.vehiclerenter.vehicleinfoservice.dto.BrandDto
import com.vehiclerenter.vehicleinfoservice.service.BrandService
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/brands")
class BrandController(val service: BrandService) {

    @GetMapping
    fun getBrands(
        @RequestHeader("Accept-Language", required = false, defaultValue = "ENGLISH") locale: Locale
    ): ResponseEntity<CollectionModel<BrandDto>> {

        val brands = service.getBrands()

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                CollectionModel
                    .of(brands)
                    .add(linkTo<BrandController> { getBrands(locale) }.withSelfRel())
            )
    }
}
