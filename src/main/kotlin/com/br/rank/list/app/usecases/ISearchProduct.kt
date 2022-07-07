package com.br.rank.list.app.usecases

import com.br.rank.list.domains.Product

interface ISearchProduct {

    fun execute(q: String): Collection<Product>

    fun execute(q: String, page: Int, size: Int): Collection<Product>
}