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
        val idUser: Long? = null,

        @Column(nullable = false, unique = true, length = 40)
        @Email
        val email: String? = null,

        @Column(nullable = false, length = 30)
        val nombre: String? = null,

        @Column(nullable = false, length = 40)
        val apellido: String? = null,

        @Column(nullable = false, length = 80)
        val password: String? = null,

        @Transient
        val confirmPassword: String? = null,

        @Column(length = 20)
        var state: String? = null,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "UserRol", joinColumns = [JoinColumn(name = "idUser")], inverseJoinColumns = [JoinColumn(name = "idRol")])
        var rol: Set<Rol>? = null,

        @OneToMany(mappedBy = "user")
        val vent: List<Venta>? = null

        ) : Serializable {

    @PrePersist
    fun init(){
        state = "ACTIVO"
    }

    override fun toString(): String {
        return "User(idUser=$idUser, email=$email, nombre=$nombre, apellido=$apellido, password=$password, confirmPassword='$confirmPassword', state='$state')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (email != other.email) return false
        if (nombre != other.nombre) return false
        if (apellido != other.apellido) return false
        if (password != other.password) return false
        if (confirmPassword != other.confirmPassword) return false
        if (state != other.state) return false
        if (rol != other.rol) return false
        if (vent != other.vent) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email?.hashCode() ?: 0
        result = 31 * result + (nombre?.hashCode() ?: 0)
        result = 31 * result + (apellido?.hashCode() ?: 0)
        result = 31 * result + (password?.hashCode() ?: 0)
        result = 31 * result + (confirmPassword?.hashCode() ?: 0)
        result = 31 * result + (state?.hashCode() ?: 0)
        result = 31 * result + (vent?.hashCode() ?: 0)
        return result
    }

}