package com.tcomics.store.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Clasificaciones")
data class Clasificacion constructor(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idClasificacion: Int? = null,

        @Column
        val nombre: String? = null,

        @OneToMany(mappedBy = "clasificacion")
        @JsonIgnore
        val comic: List<Comic>? = null

        ) : Serializable {

        override fun toString(): String {
                return "Clasificacion(idClasificacion=$idClasificacion, nombre=$nombre, comic=$comic)"
        }
}