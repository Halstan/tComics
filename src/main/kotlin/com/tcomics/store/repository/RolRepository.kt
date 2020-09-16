package com.tcomics.store.repository

import com.tcomics.store.entity.Rol
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolRepository : JpaRepository<Rol, Int>{
}