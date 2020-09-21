package com.tcomics.store.controller.api

import com.tcomics.store.entity.Comic
import com.tcomics.store.service.ComicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/comics")
class ApiComicController constructor(
        @Autowired
        val comicService: ComicService
    ) {

    @GetMapping(produces = ["application/json"])
    private fun getAll(): ResponseEntity<List<Comic>> {
        val comics: List<Comic> = this.comicService.findAll()

        return ResponseEntity(comics, HttpStatus.OK)
    }

    @GetMapping("{idComic}", produces = ["application/json"])
    private fun findComicById(@PathVariable idComic: Long): ResponseEntity<Optional<Comic>>{
        val comic: Optional<Comic> = this.comicService.findComicById(idComic)

        return ResponseEntity(comic, HttpStatus.OK)
    }

}