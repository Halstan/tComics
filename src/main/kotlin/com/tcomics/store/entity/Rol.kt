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
                return "Rol(idRol=$idRol, type=$type)"
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Rol) return false

                if (idRol != other.idRol) return false
                if (type != other.type) return false
                if (user != other.user) return false

                return true
        }

        override fun hashCode(): Int {
                var result = idRol ?: 0
                result = 31 * result + (type?.hashCode() ?: 0)
                return result
        }

}