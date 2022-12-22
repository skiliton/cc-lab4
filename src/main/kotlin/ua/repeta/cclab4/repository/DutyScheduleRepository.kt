package ua.repeta.cclab4.repository

import ua.repeta.cclab4.model.DutySchedule
import java.time.DayOfWeek
import java.time.OffsetTime
import java.util.*

interface DutyScheduleRepository {
    fun create(dutySchedule: DutySchedule): DutySchedule
    fun removeById(id: UUID): DutySchedule?
    fun getAll(): List<DutySchedule>
    fun update(
        id: UUID,
        name: String? = null,
        surname: String? = null,
        description: String? = null,
        schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>? = null
    ): DutySchedule?
}
