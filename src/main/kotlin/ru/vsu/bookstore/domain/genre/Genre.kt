package ru.vsu.bookstore.domain.genre

import ru.vsu.bookstore.domain.show.Show
import jdk.nashorn.internal.ir.annotations.Ignore
import java.io.Serializable
import javax.persistence.*

@Entity
data class Genre(
        var name: String = "",
        @OneToMany(mappedBy = "genre", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @Ignore
        var shows: MutableSet<Show> = mutableSetOf(),
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
): Serializable