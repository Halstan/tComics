package com.tcomics.store.controller

import com.tcomics.store.entity.Author
import com.tcomics.store.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import javax.validation.Valid


@Controller
@RequestMapping("autores")
class AuthorController constructor(
        @Autowired
        val authorService: AuthorService
){

    @GetMapping("/listar")
    private fun showAll(model: Model): String{
        model.addAttribute("authors", authorService.findAll())
        return "ListAuthors"
    }

    @GetMapping("/agregar")
    private fun addAuthor(author: Author): String{
        return "AddAuthor"
    }

    @PostMapping("/agregar")
    private fun addAuthorPost(@Valid author: Author, model: Model): String{
        this.authorService.addAuthor(author)
        model.addAttribute("authors", this.authorService.findAll())
        return "redirect:/autores/listar"
    }

    @GetMapping("/editar/{idAuthor}")
    private fun editAuthorById(model: Model, @PathVariable idAuthor: Optional<Int>): String? {
        val author = Author()
        if (idAuthor.isPresent) {
            val author2: Optional<Author> = this.authorService.findAuthorById(idAuthor.get())
            model.addAttribute("author", author2)
        } else {
            model.addAttribute("author", author)
        }
        return "AddAuthor"
    }

    @GetMapping("/eliminar/{idAuthor}")
    private fun deleteAuthor(@PathVariable idAuthor: Int): String{
        this.authorService.deleteAuthor(idAuthor)
        return "redirect:/autores/listar"
    }

}