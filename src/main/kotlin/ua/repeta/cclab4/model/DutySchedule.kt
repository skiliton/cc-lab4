package ua.repeta.cclab4.model

import java.time.DayOfWeek
import java.time.OffsetTime
import java.util.*

data class DutySchedule(
    val id: UUID = UUID.randomUUID(),
    var name: String?,
    var surname: String?,
    var description: String?,
    var schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>?
)
