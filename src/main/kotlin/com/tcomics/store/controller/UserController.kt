package com.tcomics.store.controller

import com.tcomics.store.entity.Rol
import com.tcomics.store.entity.User
import com.tcomics.store.service.RolService
import com.tcomics.store.service.UserService
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
@RequestMapping("usuarios")
class UserController @Autowired constructor(
        val rolService: RolService,
        val userService: UserService
    ){

    @GetMapping("listar")
    private fun showAll(model: Model): String{
        model.addAttribute("users", this.userService.findAll())
        return "user/ListUser"
    }

    @GetMapping("/agregar")
    private fun addUser(user: User, model: Model): String{
        return "user/AddUser"
    }

    @PostMapping("/agregar")
    private fun addUserPost(@Valid user: User, model: Model): String{
        return if (user.password.equals(user.confirmPassword)) {
            val roles: Set<Rol> = this.rolService.findRolsByName("USER")
            user.rol = roles
            this.userService.addUser(user)
            model.addAttribute("users", this.userService.findAll())
            "redirect:/usuarios/listar"
        }else {
            "user/AddUser"
        }
    }

    @GetMapping("/editar/{idUser}")
    private fun editUserById(model: Model, @PathVariable idUser: Optional<Long>): String? {
        if (idUser.isPresent) {
            val user2: Optional<User> = this.userService.findUserById(idUser.get())
            model.addAttribute("user", user2)
        } else {
            model.addAttribute("user", User())
        }
        return "user/AddUser"
    }

    @GetMapping("/eliminar/{idUser}")
    private fun deleteUser(@PathVariable idUser: Long): String{
        this.userService.deleteUser(idUser)
        return "redirect:/usuarios/listar"
    }
}