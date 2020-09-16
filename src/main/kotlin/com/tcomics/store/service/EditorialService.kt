package com.tcomics.store.service

import com.tcomics.store.entity.Editorial
import com.tcomics.store.repository.EditorialRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class EditorialService constructor(
        @Autowired
        val editorialRepository: EditorialRepository
    ){

    fun findAll(): List<Editorial>{
        return this.editorialRepository.findAll()
    }

    fun addEditorial(editorial: Editorial): Editorial{
        return this.editorialRepository.save(editorial)
    }

    fun updateEditorial(editorial: Editorial): Editorial{
        return this.editorialRepository.save(editorial)
    }

    fun deleteEditorial(idEditorial: Int){
        this.editorialRepository.deleteById(idEditorial)
    }

    fun findEditorialById(idEditorial: Int): Optional<Editorial>{
        return this.editorialRepository.findById(idEditorial)
    }

}