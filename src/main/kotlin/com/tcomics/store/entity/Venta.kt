package com.tcomics.store.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Ventas")
data class Venta constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idVenta: Long?,

        @ManyToOne
        @JoinColumn(name = "idUser")
        val user: User?,

        @ManyToOne
        @JoinColumn(name = "idComic")
        val comic: Comic? = null,

        @CreationTimestamp
        val fechaVenta: Date?,

        @UpdateTimestamp
        val fechaDesactivo: Date?,

        @Column(length = 25)
        var state: String,

        @Column
        val precioBruto: Double?,

        @Column
        val precioTotal: Double?,

        @Column
        val cantidad: Short?

        ) : Serializable {

    @PrePersist
    fun init(){
        state = "ACTIVO"
    }
}