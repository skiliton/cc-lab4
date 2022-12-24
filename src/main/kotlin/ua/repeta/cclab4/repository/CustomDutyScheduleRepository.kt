package ua.repeta.cclab4.repository

import com.mongodb.client.result.UpdateResult
import org.bson.types.ObjectId
import java.time.DayOfWeek
import java.time.LocalTime

interface CustomDutyScheduleRepository {
    fun update(
        id: ObjectId,
        name: String? = null,
        surname: String? = null,
        description: String? = null,
        schedule: Map<DayOfWeek, Pair<LocalTime, LocalTime>>? = null
    ): UpdateResult
}
