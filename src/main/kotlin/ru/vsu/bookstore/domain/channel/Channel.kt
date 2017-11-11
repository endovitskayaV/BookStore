package ru.vsu.bookstore.domain.channel

import ru.vsu.bookstore.domain.schedule.ChannelSchedule
import java.io.Serializable
import javax.persistence.*

@Entity
data class Channel(
        var name: String = "",
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        var schedule: ChannelSchedule? = ChannelSchedule(),
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
): Serializable