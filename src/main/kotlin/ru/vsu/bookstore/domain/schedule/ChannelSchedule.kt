package ru.vsu.bookstore.domain.schedule

import ru.vsu.bookstore.domain.channel.Channel
import ru.vsu.bookstore.domain.show.Show
import java.io.Serializable
import javax.persistence.*

@Entity
data class ChannelSchedule(
        @OneToMany(mappedBy = "schedule", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        @OrderBy("startTime ASC")
        var shows: MutableList<Show> = mutableListOf(),
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
): Serializable