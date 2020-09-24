package com.tcomics.store.repository

import com.tcomics.store.entity.Comic
import com.tcomics.store.entity.Editorial
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ComicRepository : JpaRepository<Comic, Long>{

    fun findComicsByEditorialIdEditorial(idEditorial: Int): List<Comic>

}