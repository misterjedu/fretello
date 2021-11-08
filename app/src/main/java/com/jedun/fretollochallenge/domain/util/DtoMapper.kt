package com.jedun.fretollochallenge.domain.util

interface DtoMapper<Dto, DomainModel> {

    fun mapFromDto(dto: Dto): DomainModel

    fun mapToDto(domainModel: DomainModel): Dto
}