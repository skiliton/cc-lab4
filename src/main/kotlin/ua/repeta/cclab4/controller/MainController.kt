package ua.repeta.cclab4.controller

import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ua.repeta.cclab4.dto.DutyScheduleCreateDto
import ua.repeta.cclab4.dto.DutyScheduleReadDto
import ua.repeta.cclab4.dto.DutyScheduleUpdateDto
import ua.repeta.cclab4.mapper.DutyScheduleDtoMappers
import ua.repeta.cclab4.repository.DutyScheduleRepository
import java.util.*

@RestController
class MainController(
    val repository: DutyScheduleRepository
) {
    @PostMapping("/duty-schedule/")
    fun create(@RequestBody dutyScheduleCreateDto: DutyScheduleCreateDto): ResponseEntity<DutyScheduleReadDto> {
        val dutySchedule = repository.save(DutyScheduleDtoMappers.mapToDutySchedule(dutyScheduleCreateDto))
        return ResponseEntity(DutyScheduleDtoMappers.mapToDutyScheduleReadDto(dutySchedule), HttpStatus.CREATED)
    }

    @GetMapping("/duty-schedule/")
    fun read(): List<DutyScheduleReadDto> {
        return repository.findAll().map(DutyScheduleDtoMappers::mapToDutyScheduleReadDto)
    }

    @PatchMapping("/duty-schedule/{id}")
    fun update(
        @RequestBody dutyScheduleUpdateDto: DutyScheduleUpdateDto,
        @PathVariable id: String
    ): ResponseEntity<DutyScheduleReadDto> {
        val updateResult = repository.update(
            id = ObjectId(id),
            name = dutyScheduleUpdateDto.name,
            surname = dutyScheduleUpdateDto.surname,
            description = dutyScheduleUpdateDto.description,
            schedule = dutyScheduleUpdateDto.schedule,
        )
        return if (updateResult.matchedCount > 0 )
            ResponseEntity(HttpStatus.OK)
        else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/duty-schedule/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    fun delete(
        @PathVariable id: String
    ) {
        repository.deleteById(ObjectId(id))
    }
}
