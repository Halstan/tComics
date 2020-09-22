package com.tcomics.store.controller

import com.tcomics.store.entity.Venta
import com.tcomics.store.service.ComicService
import com.tcomics.store.service.UserService
import com.tcomics.store.service.VentaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.lang.IllegalArgumentException
import java.util.*
import javax.validation.Valid

@Controller
@RequestMapping("ventas")
class VentaController @Autowired constructor(
        val userService: UserService,
        val comicService: ComicService,
        val ventaService: VentaService
    ){

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("ventas", this.ventaService.findAll())

        return "venta/ListVenta"
    }

    @GetMapping("/agregar")
    private fun addVenta(venta: Venta, model: Model): String{
        model.addAttribute("users", this.userService.findAll())
        model.addAttribute("comics", this.comicService.findAll())
        return "venta/AddVenta"
    }

    @PostMapping("/agregar")
    private fun addVentaPost(@Valid venta: Venta, model: Model): String{
        if (venta.cantidad!! > venta.comic?.cantidad!!){
            return "redirect:/comics/listar"
        }

        venta.precioTotal = venta.cantidad * venta.comic.precio!!

        this.ventaService.makeVenta(venta.cantidad, venta.comic.idComic)

        this.ventaService.addVenta(venta)

        model.addAttribute("ventas", this.ventaService.findAll())
        return "redirect:/ventas/listar"
    }

    @GetMapping("/desactivar/{idVenta}")
    private fun deleteUser(@PathVariable idVenta: Long): String{
        this.ventaService.desactivateVenta(idVenta)

        return "redirect:/ventas/listar"
    }
}