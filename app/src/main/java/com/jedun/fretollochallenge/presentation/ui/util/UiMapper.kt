package com.jedun.fretollochallenge.presentation.ui.util

interface UiMapper<Dto, UiModel> {

    fun mapFromDto(dto: Dto): UiModel

}