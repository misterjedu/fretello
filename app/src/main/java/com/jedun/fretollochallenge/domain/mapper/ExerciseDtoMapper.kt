package com.jedun.fretollochallenge.domain.mapper

import com.jedun.fretollochallenge.domain.model.Exercise
import com.jedun.fretollochallenge.domain.util.DtoMapper
import com.jedun.fretollochallenge.data.network.model.ExerciseDto
import javax.inject.Inject

class ExerciseDtoMapper @Inject constructor() : DtoMapper<ExerciseDto, Exercise> {
    override fun mapFromDto(dto: ExerciseDto): Exercise {
        return Exercise(
            dto.exerciseId,
            dto.name,
            dto.practicedAtBpm
        )
    }

    override fun mapToDto(domainModel: Exercise): ExerciseDto {
        return ExerciseDto(
            domainModel.exerciseId,
            domainModel.name,
            domainModel.practicedAtBpm
        )
    }
}