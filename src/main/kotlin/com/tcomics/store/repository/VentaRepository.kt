package com.tcomics.store.repository

import com.tcomics.store.entity.Venta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface VentaRepository : JpaRepository<Venta, Long>{

    fun findVentasByUserIdUser(idUser: Long): List<Venta>

    @Modifying
    @Transactional
    @Query("UPDATE comics SET cantidad = cantidad - :cant where id_comic = :id", nativeQuery = true)
    fun makeVenta(@Param("cant") cantidad: Short?, @Param("id") idComic: Long?)

    @Modifying
    @Query("UPDATE ventas SET state = 'DESACTIVADO' where id_venta = :id", nativeQuery = true)
    fun desactivateVenta(@Param("id") idVenta: Long)
}