package com.br.rank.list.domains

import java.math.BigDecimal

data class Promotion(
  val description: String?, val promotionPrice: BigDecimal?, val dayAndHours: Collection<DayAndHours>?
){
  constructor(): this("", BigDecimal.ZERO, emptyList())
}