package ua.repeta.cclab4.repository

import org.springframework.stereotype.Repository
import ua.repeta.cclab4.extension.timeOfTheDay
import ua.repeta.cclab4.model.DutySchedule
import java.time.DayOfWeek
import java.time.OffsetTime
import java.util.*

@Repository
class ImplDutyScheduleRepository : DutyScheduleRepository {

    private val storage = Collections.synchronizedMap(
        mutableMapOf<UUID, DutySchedule>(
            DutySchedule(
                name = "Ivasik",
                surname = "Telesyk",
                description = "Gardening",
                schedule = mapOf(
                    DayOfWeek.MONDAY to (timeOfTheDay(11, 30) to timeOfTheDay(13, 0)),
                    DayOfWeek.FRIDAY to (timeOfTheDay(11, 30) to timeOfTheDay(13, 0))
                )
            ).let { it.id to it }
        )
    )

    override fun create(dutySchedule: DutySchedule): DutySchedule {
        return storage.putIfAbsent(dutySchedule.id, dutySchedule) ?: dutySchedule
    }

    override fun removeById(id: UUID): DutySchedule? {
        return storage.remove(id)
    }

    override fun getAll(): List<DutySchedule> {
        return storage.values.toList()
    }

    override fun update(
        id: UUID,
        name: String?,
        surname: String?,
        description: String?,
        schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>?
    ): DutySchedule? {
        return storage.computeIfPresent(id) { _, dutySchedule ->
            name?.let { dutySchedule.name = it }
            surname?.let { dutySchedule.surname = it }
            description?.let { dutySchedule.description = it }
            schedule?.let { dutySchedule.schedule = it }
            dutySchedule
        }
    }
}
