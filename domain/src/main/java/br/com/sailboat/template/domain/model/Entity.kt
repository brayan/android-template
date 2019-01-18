package br.com.sailboat.template.domain.model

import java.math.BigDecimal

class Entity(
    var id: Long = -1,
    val name: String,
    val description: String,
    var quantity: Int = 0,
    var price: BigDecimal
)