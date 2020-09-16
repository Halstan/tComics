package com.tcomics.store.service

import com.tcomics.store.entity.Clasificacion
import com.tcomics.store.repository.ClasificacionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class ClasificacionService constructor(
        @Autowired
        val clasificacionRepository: ClasificacionRepository
    ){

    fun findAll(): List<Clasificacion>{
        return this.clasificacionRepository.findAll()
    }

    fun addClasificacion(clasificacion: Clasificacion): Clasificacion{
        return this.clasificacionRepository.save(clasificacion)
    }

    fun updateClasificacion(clasificacion: Clasificacion): Clasificacion{
        return this.clasificacionRepository.save(clasificacion)
    }

    fun findClasificacionById(idClasificacion: Int): Optional<Clasificacion>{
        return this.clasificacionRepository.findById(idClasificacion)
    }

    fun deleteClasificacion(idClasificacion: Int){
        this.clasificacionRepository.deleteById(idClasificacion)
    }
}