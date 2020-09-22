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
        val idVenta: Long? = null,

        @ManyToOne
        @JoinColumn(name = "idUser")
        val user: User? = null,

        @ManyToOne
        @JoinColumn(name = "idComic")
        val comic: Comic? = null,

        @CreationTimestamp
        val fechaVenta: Date? = null,

        @UpdateTimestamp
        val fechaDesactivo: Date? = null,

        @Column(length = 25)
        var state: String? = null,

        @Column
        var precioTotal: Double? = null,

        @Column
        val cantidad: Short? = null

        ) : Serializable {

    @PrePersist
    fun init() {
        state = "ACTIVO"
    }

    override fun toString(): String {
        return "Venta(idVenta=$idVenta, user=$user, comic=$comic, fechaVenta=$fechaVenta, fechaDesactivo=$fechaDesactivo, state='$state', precioTotal=$precioTotal, cantidad=$cantidad)"
    }

}