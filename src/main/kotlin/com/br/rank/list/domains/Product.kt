package com.br.rank.list.domains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(
    val id: String, val code: String, val name: String, val price: BigDecimal,
    val categories: Categories, val promotionActive: Boolean
    ){

    constructor(): this("", "","", BigDecimal.ZERO, Categories(), false)
}