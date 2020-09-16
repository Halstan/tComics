package com.tcomics.store.repository

import com.tcomics.store.entity.Editorial
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EditorialRepository : JpaRepository<Editorial, Int>{
}