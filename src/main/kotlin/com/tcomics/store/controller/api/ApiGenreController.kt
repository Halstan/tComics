package com.tcomics.store.controller.api

import com.tcomics.store.entity.Genre
import com.tcomics.store.service.GenreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/genres")
class ApiGenreController constructor(
        @Autowired
        val genreService: GenreService
    ){

    @GetMapping(produces = ["application/json"])
    private fun findAll(): ResponseEntity<List<Genre>>{
        val genres: List<Genre> = this.genreService.findAll()

        return ResponseEntity(genres, HttpStatus.OK)
    }

    @GetMapping("{idGenre}", produces = ["application/json"])
    private fun findGenreById(@PathVariable idGenre: Int): ResponseEntity<Optional<Genre>>{
        val genre: Optional<Genre> = this.genreService.findGenreById(idGenre)

        return ResponseEntity(genre, HttpStatus.OK)
    }
}