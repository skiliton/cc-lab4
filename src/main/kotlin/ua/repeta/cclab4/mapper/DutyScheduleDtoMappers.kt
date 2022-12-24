package ua.repeta.cclab4.mapper

import ua.repeta.cclab4.dto.DutyScheduleCreateDto
import ua.repeta.cclab4.dto.DutyScheduleReadDto
import ua.repeta.cclab4.model.DutySchedule

object DutyScheduleDtoMappers {
    fun mapToDutySchedule(original: DutyScheduleCreateDto): DutySchedule {
        return DutySchedule(
            name = original.name,
            surname = original.surname,
            description = original.description,
            schedule = original.schedule,
        )
    }

    fun mapToDutyScheduleReadDto(original: DutySchedule): DutyScheduleReadDto {
        return DutyScheduleReadDto(
            id = original.id!!.toHexString(),
            name = original.name!!,
            surname = original.surname!!,
            description = original.description!!,
            schedule = original.schedule!!,
        )
    }
}
