package com.br.rank.list.infra.http

import com.br.rank.list.app.usecases.impl.SearchProduct
import com.br.rank.list.domains.Product
import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("search")
@Api(tags = ["Search"])
class SearchMeiliController(private val searchProduct: SearchProduct) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun execute(@RequestParam q: String): Collection<Product> {
        return searchProduct.execute(q);
    }

    @GetMapping("page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    fun execute(@RequestParam q: String, @PathVariable page: Int, @PathVariable size: Int): Collection<Product> {
        return searchProduct.execute(q, page, size);
    }
}