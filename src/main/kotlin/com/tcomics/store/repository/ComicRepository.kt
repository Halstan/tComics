package com.tcomics.store.repository

import com.tcomics.store.entity.Comic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComicRepository : JpaRepository<Comic, Long>{
}