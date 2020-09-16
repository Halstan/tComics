package com.tcomics.store.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Genres")
data class Genre constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idGenre: Int?,

        @Column(length = 30)
        val nombre: String?,

        @OneToMany(mappedBy = "genero")
        val comics: List<Comic>?

        ): Serializable{
}