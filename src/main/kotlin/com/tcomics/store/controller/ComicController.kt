package com.tcomics.store.controller

import com.tcomics.store.entity.Comic
import com.tcomics.store.entity.Genre
import com.tcomics.store.entity.Rol
import com.tcomics.store.service.*
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
@RequestMapping("comics")
class ComicController @Autowired constructor(
        val comicService: ComicService,
        val clasificacionService: ClasificacionService,
        val authorService: AuthorService,
        val genreService: GenreService,
        val editorialService: EditorialService
    ){

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("comics", this.comicService.findAll())

        return "comic/ListComic"
    }

    @GetMapping("/agregar")
    private fun addComic(comic: Comic, model: Model): String{

        model.addAttribute("clasificaciones", this.clasificacionService.findAll())

        model.addAttribute("authors", this.authorService.findAll())

        model.addAttribute("genres", this.genreService.findAll())

        model.addAttribute("editoriales", this.editorialService.findAll())

        return "comic/AddComic"
    }

    @PostMapping("/agregar")
    private fun addComicPost(@Valid comic: Comic, model: Model): String{
        this.comicService.addComic(comic)
        model.addAttribute("roles", this.comicService.findAll())
        return "redirect:/comics/listar"
    }

    @GetMapping("/editar/{idComic}")
    private fun editComicById(model: Model, @PathVariable idComic: Optional<Long>): String? {
        if (idComic.isPresent) {
            val comic2: Optional<Comic> = this.comicService.findComicById(idComic.get())
            model.addAttribute("comic", comic2)
        } else {
            model.addAttribute("comic", Comic())
        }
        return "comic/AddComic"
    }

    @GetMapping("/eliminar/{idComic}")
    private fun deleteComic(@PathVariable idComic: Long): String{
        this.comicService.deleteComic(idComic)
        return "redirect:/comics/listar"
    }
}