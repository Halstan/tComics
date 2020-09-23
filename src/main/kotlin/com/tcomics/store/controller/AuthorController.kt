package com.tcomics.store.controller

import com.tcomics.store.entity.Author
import com.tcomics.store.service.AuthorService
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
@RequestMapping("autores")
class AuthorController constructor(
        @Autowired
        val authorService: AuthorService
){

    @GetMapping("/listar")
    private fun showAll(model: Model): String{
        model.addAttribute("authors", authorService.findAll())
        return "author/ListAuthors"
    }

    @GetMapping("/agregar")
    private fun addAuthor(author: Author): String{
        return "author/AddAuthor"
    }

    @PostMapping("/agregar")
    private fun addAuthorPost(@Valid author: Author, model: Model,  @RequestParam("file") foto: MultipartFile): String{

        if(!foto.isEmpty){
            val uniqueName: String = UUID.randomUUID().toString() + "_" + foto.originalFilename.toString()
            val rootPath: Path = Paths.get("uploads/author").resolve(uniqueName)
            val absolutePath: Path = rootPath.toAbsolutePath()

            try {
                Files.copy(foto.inputStream, absolutePath)
                author.foto = uniqueName
            }catch (e: IOException){
                e.printStackTrace()
            }
        }

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
        return "author/AddAuthor"
    }

    @GetMapping("/eliminar/{idAuthor}")
    private fun deleteAuthor(@PathVariable idAuthor: Int): String{
        this.authorService.deleteAuthor(idAuthor)
        return "redirect:/autores/listar"
    }

}