package com.br.rank.list.domains

data class Categories(
    val values: Collection<String>
) {

    constructor() : this(emptyList())
}