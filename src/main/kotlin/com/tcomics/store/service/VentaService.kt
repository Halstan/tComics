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
    ){

    fun findAll(): List<Venta>{
        return this.ventaRepository.findAll()
    }

    fun addVenta(venta: Venta): Venta{
        return this.ventaRepository.save(venta)
    }

    fun updateVenta(venta: Venta): Venta{
        return this.ventaRepository.save(venta)
    }

    fun findVentaById(idVenta: Long): Optional<Venta>{
        return this.ventaRepository.findById(idVenta)
    }

    fun deleteVenta(idVenta: Long){
        return this.ventaRepository.deleteById(idVenta)
    }

    fun findVentaByUser(idUser: Long): List<Venta>{
        return this.ventaRepository.findVentasByUserIdUser(idUser)
    }
}