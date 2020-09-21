package com.tcomics.store.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Genres")
data class Genre constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idGenre: Int? = null,

        @Column(length = 30)
        val nombre: String? = null,

        @OneToMany(mappedBy = "genero")
        @JsonIgnore
        val comics: List<Comic>? = null

        ): Serializable{

        override fun toString(): String {
                return "Genre(idGenre=$idGenre, nombre=$nombre)"
        }
}