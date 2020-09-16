package com.tcomics.store.service

import com.tcomics.store.entity.Rol
import com.tcomics.store.repository.RolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class RolService constructor(
        @Autowired
        val rolRepository: RolRepository
    ){

    fun findAll(): List<Rol>{
        return this.rolRepository.findAll()
    }

    fun addRol(rol: Rol): Rol{
        return this.rolRepository.save(rol)
    }

    fun updateRol(rol: Rol): Rol{
        return this.rolRepository.save(rol)
    }

    fun findById(idRol: Int): Optional<Rol>{
        return this.rolRepository.findById(idRol)
    }

    fun deleteRol(idRol: Int){
        this.rolRepository.deleteById(idRol)
    }
}