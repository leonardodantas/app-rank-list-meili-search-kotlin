package com.br.rank.list.app.providers

import com.br.rank.list.domains.Product

interface Provider {

    fun search(q: String): Collection<Product>

    fun search(q: String, page: Int, size: Int): Collection<Product>
}