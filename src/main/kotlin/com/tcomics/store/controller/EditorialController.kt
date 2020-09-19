package com.tcomics.store.controller

import com.tcomics.store.entity.Clasificacion
import com.tcomics.store.entity.Editorial
import com.tcomics.store.service.EditorialService
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
@RequestMapping("editoriales")
class EditorialController constructor(
        @Autowired
        val editorialService: EditorialService
    ){

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("editoriales", this.editorialService.findAll())

        return "editorial/ListEditorial"
    }

    @GetMapping("/agregar")
    private fun addEditorial(editorial: Editorial): String{
        return "editorial/AddEditorial"
    }

    @PostMapping("/agregar")
    private fun addEditorialPost(@Valid editorial: Editorial, model: Model): String{
        this.editorialService.addEditorial(editorial)
        model.addAttribute("editoriales", this.editorialService.findAll())
        return "redirect:/editoriales/listar"
    }

    @GetMapping("/editar/{idEditorial}")
    private fun editEditorialById(model: Model, @PathVariable idEditorial: Optional<Int>): String? {
        if (idEditorial.isPresent) {
            val editorial2: Optional<Editorial> = this.editorialService.findEditorialById(idEditorial.get())
            model.addAttribute("editorial", editorial2)
        } else {
            model.addAttribute("editorial", Editorial())
        }
        return "editorial/AddEditorial"
    }

    @GetMapping("/eliminar/{idEditorial}")
    private fun deleteEditorial(@PathVariable idEditorial: Int): String{
        this.editorialService.deleteEditorial(idEditorial)
        return "redirect:/editoriales/listar"
    }


}