package ua.repeta.cclab4.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.DayOfWeek
import java.time.OffsetTime
import java.util.*

@Document("duty-schedule")
data class DutySchedule(
    val id: ObjectId? = null,
    var name: String? = null,
    var surname: String? = null,
    var description: String? = null,
    var schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>? = null
)
