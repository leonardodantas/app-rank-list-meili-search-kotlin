package com.br.rank.list.app.usecases.impl

import com.br.rank.list.app.providers.Provider
import com.br.rank.list.app.usecases.ISearchProduct
import com.br.rank.list.domains.Product
import org.springframework.stereotype.Component

@Component
class SearchProduct(
    val provider: Provider
) : ISearchProduct {

    override fun execute(q: String): Collection<Product> {
        return provider.search(q);
    }

    override fun execute(q: String, page: Int, size: Int): Collection<Product> {
        return provider.search(q, page, size);
    }
}