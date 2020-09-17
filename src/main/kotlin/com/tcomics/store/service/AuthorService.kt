package com.tcomics.store.service

import com.tcomics.store.entity.Author
import com.tcomics.store.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class AuthorService constructor (
        @Autowired
        val authorRepository: AuthorRepository
    ) {

    fun findAll(): List<Author> {
        return this.authorRepository.findAll()
    }

    fun addAuthor(author: Author): Author {
        return this.authorRepository.save(author)
    }

    fun updateAuthor(author: Author): Author {
        return this.authorRepository.save(author)
    }

    fun findAuthorById(idAuthor: Int): Optional<Author>{
        return this.authorRepository.findById(idAuthor)
    }

    fun deleteAuthor(idAuthor: Int){
        this.authorRepository.deleteById(idAuthor)
    }

}