package com.tcomics.store.repository

import com.tcomics.store.entity.Clasificacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClasificacionRepository : JpaRepository<Clasificacion, Int>{
}