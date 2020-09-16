package com.tcomics.store.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Clasificaciones")
data class Clasificacion constructor(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idClasificacion: Int?,

        @Column
        val nombre: String?,

        @OneToMany(mappedBy = "clasificacion")
        val comic: List<Comic>?

        ) : Serializable {
}