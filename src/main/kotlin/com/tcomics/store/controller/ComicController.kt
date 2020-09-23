package com.tcomics.store.controller

import com.tcomics.store.entity.Comic
import com.tcomics.store.entity.Genre
import com.tcomics.store.entity.Rol
import com.tcomics.store.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
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

    private fun getModels(model: Model){
        model.addAttribute("clasificaciones", this.clasificacionService.findAll())
        model.addAttribute("authors", this.authorService.findAll())
        model.addAttribute("genres", this.genreService.findAll())
        model.addAttribute("editoriales", this.editorialService.findAll())
    }

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("comics", this.comicService.findAll())

        return "comic/ListComic"
    }

    @GetMapping("/agregar")
    private fun addComic(comic: Comic, model: Model): String{
        getModels(model)

        return "comic/AddComic"
    }

    @PostMapping("/agregar")
    private fun addComicPost(@Valid comic: Comic, @RequestParam("file") foto: MultipartFile, model: Model): String{

        if(!foto.isEmpty){
            val uniqueName: String = UUID.randomUUID().toString() + "_" + foto.originalFilename.toString()
            val rootPath: Path = Paths.get("uploads/comic").resolve(uniqueName)
            val absolutePath: Path = rootPath.toAbsolutePath()

            try {
                Files.copy(foto.inputStream, absolutePath)
                comic.portada = uniqueName
            }catch (e: IOException){
                e.printStackTrace()
            }
        }

        this.comicService.addComic(comic)
        model.addAttribute("roles", this.comicService.findAll())
        return "redirect:/comics/listar"
    }

    @GetMapping("/editar/{idComic}")
    private fun editComicById(model: Model, @PathVariable idComic: Optional<Long>): String? {
        getModels(model)
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
        val comic2: Optional<Comic> = this.comicService.findComicById(idComic)
        if (comic2.isPresent){
            if(comic2.get().ventas?.isNotEmpty()!!){
                return "redirect:/comics/listar"
            }
        }
        this.comicService.deleteComic(idComic)
        return "redirect:/comics/listar"
    }
}