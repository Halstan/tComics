package com.tcomics.store.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "Editoriales")
data class Editorial constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idEditorial: Int? = null,

        @Column(length = 30)
        @NotBlank
        @Size(max = 30, min = 1)
        val nombre: String? = null,

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        val anhoFundacion: Date? = null,

        @OneToMany(mappedBy = "editorial")
        @JsonIgnore
        val comics: List<Comic>? = null

        ) : Serializable {

        override fun toString(): String {
                return "Editorial(idEditorial=$idEditorial, nombre=$nombre, anhoFundacion=$anhoFundacion, comics=$comics)"
        }
}