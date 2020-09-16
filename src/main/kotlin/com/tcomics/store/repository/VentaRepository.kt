package com.tcomics.store.repository

import com.tcomics.store.entity.Venta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VentaRepository : JpaRepository<Venta, Long>{

    fun findVentasByUserIdUser(idUser: Long): List<Venta>

}