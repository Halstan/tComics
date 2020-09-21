package com.tcomics.store.entity

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Email
import kotlin.collections.Set

@Entity
@Table(name = "Users")
data class User constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idUser: Long?,

        @Column(nullable = false, unique = true, length = 40)
        @Email
        val email: String?,

        @Column(nullable = false, length = 30)
        val nombre: String?,

        @Column(nullable = false, length = 40)
        val apellido: String?,

        @Column(nullable = false, length = 80)
        val password: String?,

        @Transient
        val confirmPassword: String,

        @Column(length = 20)
        var state: String,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "UserRol", joinColumns = [JoinColumn(name = "idUser")], inverseJoinColumns = [JoinColumn(name = "idRol")])
        val rol: Set<Rol>?,

        @OneToMany(mappedBy = "user")
        val vent: List<Venta>?

        ) : Serializable {

    @PrePersist
    fun init(){
        state = "ACTIVO"
    }

    override fun toString(): String {
        return "User(idUser=$idUser, email=$email, nombre=$nombre, apellido=$apellido, password=$password, confirmPassword='$confirmPassword', state='$state', rol=$rol, vent=$vent)"
    }

}