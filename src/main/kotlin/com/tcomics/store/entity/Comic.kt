package com.tcomics.store.entity

import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "Comics")
data class Comic constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idComic: Long? = null,

        @Column(length = 60)
        val nombre: String? = null,

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        val fechaPublicacion: Date? = null,

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        val fechaUltPublicacion: Date? = null,

        @Column
        @NotBlank
        val cantidad: Short? = null,

        @Column
        @NotBlank
        val precio: Double? = null,

        @NotBlank
        @Column(nullable = true, length = 255)
        val Foto: String? = null,

        @ManyToOne
        @JoinColumn(name = "idGenre")
        val genero: Genre? = null,

        @ManyToOne
        @JoinColumn(name = "idAutor")
        val author: Author? = null,

        @ManyToOne
        @JoinColumn(name = "idClasificacion")
        val clasificacion: Clasificacion? = null,

        @ManyToOne
        @JoinColumn(name = "idEditorial")
        val editorial: Editorial? = null,

        @Column(length = 20)
        var estado: String? = null,

        @OneToMany(mappedBy = "comic")
        val ventas: List<Venta>? = null

        ): Serializable {

    @PrePersist
    fun init(){
        estado = "PUBLICANDO"
    }

}