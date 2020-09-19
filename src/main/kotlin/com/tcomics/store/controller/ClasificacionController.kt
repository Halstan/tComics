package com.tcomics.store.controller

import com.tcomics.store.entity.Clasificacion
import com.tcomics.store.entity.Genre
import com.tcomics.store.service.ClasificacionService
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
@RequestMapping("clasificaciones")
class ClasificacionController  constructor(
        @Autowired
        val clasificacionService: ClasificacionService
    ){

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("clasificaciones", this.clasificacionService.findAll())

        return "clasificacion/ListClasificacion"
    }

    @GetMapping("/agregar")
    private fun addClasificacion(clasificacion: Clasificacion): String{
        return "clasificacion/AddClasificacion"
    }

    @PostMapping("/agregar")
    private fun addClasificacionPost(@Valid clasificacion: Clasificacion, model: Model): String{
        this.clasificacionService.addClasificacion(clasificacion)
        model.addAttribute("authors", this.clasificacionService.findAll())
        return "redirect:/clasificaciones/listar"
    }

    @GetMapping("/editar/{idClasificacion}")
    private fun editClasificacionById(model: Model, @PathVariable idClasificacion: Optional<Int>): String? {
        if (idClasificacion.isPresent) {
            val clasificacion2: Optional<Clasificacion> = this.clasificacionService.findClasificacionById(idClasificacion.get())
            model.addAttribute("clasificacion", clasificacion2)
        } else {
            model.addAttribute("clasificacion", Clasificacion())
        }
        return "clasificacion/AddClasificacion"
    }

    @GetMapping("/eliminar/{idClasificacion}")
    private fun deleteClasificacion(@PathVariable idClasificacion: Int): String{
        this.clasificacionService.deleteClasificacion(idClasificacion)
        return "redirect:/clasificaciones/listar"
    }
}