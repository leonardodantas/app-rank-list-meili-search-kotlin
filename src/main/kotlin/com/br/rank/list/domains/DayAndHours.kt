package com.br.rank.list.domains

import java.time.LocalTime

data class DayAndHours(
    val day: Days,
    val startTime: LocalTime,
    val endTime: LocalTime
) {
    constructor() : this(Days.FRIDAY, LocalTime.MAX, LocalTime.MAX)
}
