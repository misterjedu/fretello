package com.jedun.fretollochallenge.domain.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    private const val DATE_FORMAT = "yyyy-MM-dd"


    fun convertDateToString(date: Date): String {
        return SimpleDateFormat(DATE_FORMAT).format(date)
    }
}