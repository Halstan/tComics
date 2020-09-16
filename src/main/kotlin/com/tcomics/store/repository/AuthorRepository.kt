package com.tcomics.store.repository

import com.tcomics.store.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Int> {

    fun findAuthorsByEditorial_IdEditorial(idEditorial: Int): List<Author>

}