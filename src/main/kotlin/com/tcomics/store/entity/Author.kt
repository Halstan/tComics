package com.tcomics.store.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "Authors")
data class Author constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idAutor: Int? = null,

        @Column(length = 50)
        @NotBlank
        val nombre: String? = null,

        @Column(length = 50)
        @NotBlank
        val apellido: String? = null,

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        val fechaNacimiento: Date? = null,

        @Column
        val comicsEscritos: Short? = null,

        //@NotBlank
        @Column(nullable = true, length = 255)
        val foto: String? = null,

        @Column(length = 15)
        var estado: String? = null,

        @OneToMany(mappedBy = "author")
        val comics: List<Comic>? = null

        ): Serializable {

        @PrePersist
        fun init(){
                estado = "ACTIVO"
        }

}