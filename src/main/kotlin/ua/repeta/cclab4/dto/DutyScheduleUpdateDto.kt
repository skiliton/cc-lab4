package ua.repeta.cclab4.dto

import java.time.DayOfWeek
import java.time.OffsetTime

data class DutyScheduleUpdateDto(
    val name: String?,
    val surname: String?,
    val description: String?,
    val schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>?
)
