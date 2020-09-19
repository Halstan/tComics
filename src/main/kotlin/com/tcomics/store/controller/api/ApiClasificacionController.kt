package com.tcomics.store.controller.api

import com.tcomics.store.entity.Clasificacion
import com.tcomics.store.service.ClasificacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/clasificaciones")
class ApiClasificacionController constructor(
        @Autowired
        val clasificacionService: ClasificacionService
    ){

    @GetMapping(produces = ["application/json"])
    private fun findAll(): ResponseEntity<List<Clasificacion>>{
        val clasificaciones: List<Clasificacion> = this.clasificacionService.findAll()

        return ResponseEntity(clasificaciones, HttpStatus.OK)
    }

    @GetMapping("{idClasificacion}", produces = ["application/json"])
    private fun getClasificacionById(@PathVariable idClasificacion: Int): ResponseEntity<Optional<Clasificacion>>{
        val clasificacion: Optional<Clasificacion> = this.clasificacionService.findClasificacionById(idClasificacion)

        return ResponseEntity(clasificacion, HttpStatus.OK)
    }

}