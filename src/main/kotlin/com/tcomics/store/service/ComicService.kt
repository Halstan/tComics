package com.tcomics.store.service

import com.tcomics.store.entity.Comic
import com.tcomics.store.repository.ComicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class ComicService constructor(
        @Autowired
        val comicRepository: ComicRepository
    ){
    fun findAll(): List<Comic>{
        return this.comicRepository.findAll()
    }

    fun addComic(comic: Comic): Comic{
        return this.comicRepository.save(comic)
    }

    fun updateComic(comic: Comic): Comic{
        return this.comicRepository.save(comic)
    }

    fun findComicById(idComic: Long): Optional<Comic>{
        return this.comicRepository.findById(idComic)
    }

    fun deleteComic(idComic: Long){
        this.comicRepository.deleteById(idComic)
    }
}