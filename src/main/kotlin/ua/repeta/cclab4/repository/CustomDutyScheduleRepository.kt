package ua.repeta.cclab4.repository

import com.mongodb.client.result.UpdateResult
import org.bson.types.ObjectId
import ua.repeta.cclab4.model.DutySchedule
import java.time.DayOfWeek
import java.time.OffsetTime

interface CustomDutyScheduleRepository {
    fun update(
        id: ObjectId,
        name: String? = null,
        surname: String? = null,
        description: String? = null,
        schedule: Map<DayOfWeek, Pair<OffsetTime, OffsetTime>>? = null
    ): UpdateResult
}
