package com.tcomics.store.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Roles")
data class Rol constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idRol: Int? = null,

        @Column(nullable = false, unique = true)
        val type: String? = null,

        //LADO INVERSE
        @ManyToMany(mappedBy = "rol", fetch = FetchType.EAGER)
        val user: Set<User>? = null

        ) : Serializable {

        override fun toString(): String {
                return "Rol(idRol=$idRol, type=$type, user=$user)"
        }
}