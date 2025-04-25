package com.example.models

import jakarta.persistence.*

@Entity
@Table(name = "book", schema = "public")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column
    var title: String? = null

    @Column
    var subtitle: String? = null

    @Column
    var publisher: String? = null
}