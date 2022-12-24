package ua.repeta.cclab4.repository

import com.mongodb.client.result.UpdateResult
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component
import ua.repeta.cclab4.model.DutySchedule
import java.time.DayOfWeek
import java.time.LocalTime


@Component
class CustomDutyScheduleRepositoryImpl(
    val mongoTemplate: MongoTemplate
) : CustomDutyScheduleRepository {

    override fun update(
        id: ObjectId,
        name: String?,
        surname: String?,
        description: String?,
        schedule: Map<DayOfWeek, Pair<LocalTime, LocalTime>>?
    ): UpdateResult {
        val query = Query(Criteria.where(DutySchedule::id.name).`is`(id))
        val update = Update()
        name?.let { update.set(DutySchedule::name.name, it) }
        surname?.let { update.set(DutySchedule::surname.name, it) }
        description?.let { update.set(DutySchedule::description.name, it) }
        schedule?.let { update.set(DutySchedule::schedule.name, it) }

        return mongoTemplate.updateFirst(query, update, DutySchedule::class.java)
    }
}
