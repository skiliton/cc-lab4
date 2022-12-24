package ua.repeta.cclab4.dto

import java.time.DayOfWeek
import java.time.OffsetTime
import java.util.*

class DutyScheduleReadDto(
    val id: String,
    val name: String,
    val surname: String,
    val description: String,
    val schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>
)
