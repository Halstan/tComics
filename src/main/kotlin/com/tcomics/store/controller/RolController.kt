package com.tcomics.store.controller

import com.tcomics.store.entity.Genre
import com.tcomics.store.entity.Rol
import com.tcomics.store.service.RolService
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
@RequestMapping("roles")
class RolController constructor(
        @Autowired
        val rolService: RolService
    ){

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("roles", this.rolService.findAll())

        return "rol/ListRol"
    }

    @GetMapping("/agregar")
    private fun addRol(rol: Rol): String{
        return "rol/AddRol"
    }

    @PostMapping("/agregar")
    private fun addRolPost(@Valid rol: Rol, model: Model): String{
        this.rolService.addRol(rol)
        model.addAttribute("roles", this.rolService.findAll())
        return "redirect:/roles/listar"
    }

    @GetMapping("/editar/{idRol}")
    private fun editRolById(model: Model, @PathVariable idRol: Optional<Int>): String? {
        if (idRol.isPresent) {
            val rol2: Optional<Rol> = this.rolService.findById(idRol.get())
            model.addAttribute("rol", rol2)
        } else {
            model.addAttribute("rol", Rol())
        }
        return "rol/AddRol"
    }

    @GetMapping("/eliminar/{idRol}")
    private fun deleteRol(@PathVariable idRol: Int): String{
        this.rolService.deleteRol(idRol)
        return "redirect:/roles/listar"
    }

}