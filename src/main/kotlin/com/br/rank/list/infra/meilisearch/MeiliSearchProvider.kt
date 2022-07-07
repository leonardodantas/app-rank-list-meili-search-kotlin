package com.br.rank.list.infra.meilisearch

import com.br.rank.list.app.providers.Provider
import com.br.rank.list.domains.Product
import com.fasterxml.jackson.databind.ObjectMapper
import com.meilisearch.sdk.Client
import com.meilisearch.sdk.Config
import com.meilisearch.sdk.SearchRequest
import com.meilisearch.sdk.model.SearchResult
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MeiliSearchProvider(
    private val objectMapper: ObjectMapper,
    @Value("\${provider.meilisearch.hostUrl}")
    private val hostUrl: String,
    @Value("\${provider.meilisearch.apiKey}")
    private val apiKey: String,
    @Value("\${provider.meilisearch.uid}")
    private val uid: String,

    ) : Provider {

    override fun search(q: String): Collection<Product> {
        val searchRequest = SearchRequest(q)
        val searchResult = this.getSearchResult(searchRequest)
        return this.convertSearchResultToCollectionProduct(searchResult);
    }

    override fun search(q: String, page: Int, size: Int): Collection<Product> {
        val searchRequest = SearchRequest(q, page, size)
        val searchResult = this.getSearchResult(searchRequest)
        return this.convertSearchResultToCollectionProduct(searchResult);
    }

    private fun convertSearchResultToCollectionProduct(searchResult: SearchResult): Collection<Product> {
        val products = mutableListOf<Product>()
        searchResult.hits.map {
            val product = objectMapper.convertValue(it, Product::class.java)
            products.add(product)
        }
        return products
    }

    private fun getSearchResult(searchRequest: SearchRequest): SearchResult {
        val client = Client(Config(hostUrl, apiKey))
        return client.index(uid).search(searchRequest)
    }
}