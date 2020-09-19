package com.tcomics.store.controller.api

import com.tcomics.store.entity.Author
import com.tcomics.store.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/autores")
class ApiAuthorController constructor(
        @Autowired
        val authorService: AuthorService
    ){

    @GetMapping(produces = ["application/json"])
    private fun findAll(): ResponseEntity<List<Author>>{
        val authors: List<Author> = this.authorService.findAll()

        return ResponseEntity(authors, HttpStatus.OK)
    }

    @GetMapping( "{idAuthor}",produces = ["application/json"])
    private fun findAuthorById(@PathVariable idAuthor: Int): ResponseEntity<Optional<Author>>{
        val author: Optional<Author> = this.authorService.findAuthorById(idAuthor)

        return ResponseEntity(author, HttpStatus.OK)
    }
}