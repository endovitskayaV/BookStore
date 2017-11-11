package ru.vsu.bookstore.domain.schedule

import org.springframework.data.repository.CrudRepository

interface SchedulesRepository: CrudRepository<ChannelSchedule, Long>