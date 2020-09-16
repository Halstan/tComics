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
        val idAutor: Int?,

        @Column(length = 50)
        @NotBlank
        val nombre: String?,

        @Column(length = 50)
        @NotBlank
        val apellido: String?,

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        val fechaNacimiento: Date?,

        @Column
        val comicEscritos: Short?,

        @NotBlank
        @Column(nullable = true, length = 255)
        val foto: String?,

        @Column(length = 15)
        var estado: String,

        @ManyToOne
        @JoinColumn(name = "idEditorial")
        val editorial: Editorial?,

        @OneToMany(mappedBy = "author")
        val comics: List<Comic>?

        ): Serializable {

        @PrePersist
        fun init(){
                estado = "ACTIVO"
        }

}