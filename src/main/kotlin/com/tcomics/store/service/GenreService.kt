package com.tcomics.store.service

import com.tcomics.store.entity.Genre
import com.tcomics.store.repository.GenreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class GenreService constructor(
        @Autowired
        val genreRepository: GenreRepository
    ){

    fun findAll(): List<Genre>{
        return this.genreRepository.findAll()
    }

    fun addGenre(genre: Genre): Genre{
        return this.genreRepository.save(genre)
    }

    fun updateGenre(genre: Genre): Genre{
        return this.genreRepository.save(genre)
    }

    fun findGenreById(idGenre: Int): Optional<Genre>{
        return this.genreRepository.findById(idGenre)
    }

    fun deleteGenre(idGenre: Int){
        this.genreRepository.deleteById(idGenre)
    }
}