package com.tcomics.store.service

import com.tcomics.store.entity.Venta
import com.tcomics.store.repository.VentaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class VentaService constructor(
        @Autowired
        val ventaRepository: VentaRepository
    ) {

    fun findAll(): List<Venta> {
        return this.ventaRepository.findAll()
    }

    fun addVenta(venta: Venta): Venta {
        return this.ventaRepository.save(venta)
    }

    fun updateVenta(venta: Venta): Venta {
        return this.ventaRepository.save(venta)
    }

    fun findVentaById(idVenta: Long): Optional<Venta> {
        return this.ventaRepository.findById(idVenta)
    }

    fun desactivateVenta(idVenta: Long){
         this.ventaRepository.desactivateVenta(idVenta)
    }

    fun findVentaByUser(idUser: Long): List<Venta> {
        return this.ventaRepository.findVentasByUserIdUser(idUser)
    }

    /**
     * This function makes de sale of a comic and
     * subtract de quantity of the given comic in the venta
     * @param cantidad the quantity of subtract.
     * @param idComic the ID of the comic.
     * @author Enzo Arauco.
     */
    fun makeVenta(cantidad: Short?, idComic:Long?){
        this.ventaRepository.makeVenta(cantidad, idComic)
    }
}