package com.jedun.fretollochallenge.domain.mapper

import com.jedun.fretollochallenge.data.network.model.SessionsItemDto
import com.jedun.fretollochallenge.domain.model.SessionsItem
import com.jedun.fretollochallenge.domain.util.DateUtil
import com.jedun.fretollochallenge.domain.util.DtoMapper
import java.util.*
import javax.inject.Inject

class DomainMapper @Inject constructor(private val exerciseMapper: ExerciseDtoMapper) :
    DtoMapper<SessionsItemDto, SessionsItem> {
    override fun mapFromDto(dto: SessionsItemDto): SessionsItem {

        return SessionsItem(
            exercises = dto.exercises.map { exerciseDto -> exerciseMapper.mapFromDto(exerciseDto) },
            name = dto.name,
            practicedOnDate = DateUtil.convertDateToString(dto.practicedOnDate)
        )
    }

    override fun mapToDto(domainModel: SessionsItem): SessionsItemDto {
        return SessionsItemDto(
            exercises = domainModel.exercises.map { exercise -> exerciseMapper.mapToDto(exercise) },
            name = domainModel.name,
            practicedOnDate = Date()
        )
    }

}