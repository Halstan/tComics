package com.tcomics.store.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Editoriales")
data class Editorial constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idEditorial: Int?,

        @Column
        val nombre: String?,

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
        val anhoFundacion: Date?,

        @OneToMany(mappedBy = "editorial")
        val authors: List<Author>?

        ) : Serializable {

}