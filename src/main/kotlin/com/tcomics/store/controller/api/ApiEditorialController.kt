package com.tcomics.store.controller.api

import com.tcomics.store.entity.Editorial
import com.tcomics.store.service.EditorialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/editoriales")
class ApiEditorialController constructor(
        @Autowired
        val editorialService: EditorialService
    ){

    @GetMapping(produces = ["application/json"])
    private fun findAll(): ResponseEntity<List<Editorial>>{
        val editoriales: List<Editorial> = this.editorialService.findAll()

        return ResponseEntity(editoriales, HttpStatus.OK)
    }

    @GetMapping("{idEditorial}", produces = ["application/json"])
    private fun findEditorialById(@PathVariable idEditorial: Int): ResponseEntity<Optional<Editorial>>{
        val editorial: Optional<Editorial> = this.editorialService.findEditorialById(idEditorial)

        return ResponseEntity(editorial, HttpStatus.OK)
    }

}