package com.tcomics.store.controller

import com.tcomics.store.entity.Genre
import com.tcomics.store.service.GenreService
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
@RequestMapping("generos")
class GenreController constructor(
        @Autowired
        val genreService: GenreService
    ){

    @GetMapping("/listar")
    private fun getAll(model: Model): String{
        model.addAttribute("genres", this.genreService.findAll())
        return "genre/ListGenres"
    }

    @GetMapping("/agregar")
    private fun addGenre(genre: Genre): String{
        return "genre/AddGenre"
    }

    @PostMapping("/agregar")
    private fun addGenrePost(@Valid genre: Genre, model: Model): String{
        this.genreService.addGenre(genre)
        model.addAttribute("authors", this.genreService.findAll())
        return "redirect:/generos/listar"
    }

    @GetMapping("/editar/{idGenre}")
    private fun editGenreById(model: Model, @PathVariable idGenre: Optional<Int>): String? {
        if (idGenre.isPresent) {
            val genre2: Optional<Genre> = this.genreService.findGenreById(idGenre.get())
            model.addAttribute("genre", genre2)
        } else {
            model.addAttribute("genre", Genre())
        }
        return "genre/AddGenre"
    }

    @GetMapping("/eliminar/{idGenre}")
    private fun deleteGenre(@PathVariable idGenre: Int): String{
        this.genreService.deleteGenre(idGenre)
        return "redirect:/generos/listar"
    }
}