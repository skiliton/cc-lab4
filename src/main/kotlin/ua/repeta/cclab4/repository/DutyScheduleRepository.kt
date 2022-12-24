package ua.repeta.cclab4.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import ua.repeta.cclab4.model.DutySchedule

interface DutyScheduleRepository: MongoRepository<DutySchedule, ObjectId>, CustomDutyScheduleRepository
