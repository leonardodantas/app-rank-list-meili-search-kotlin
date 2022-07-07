package com.br.rank.list.config

import springfox.documentation.service.Tag
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger(

    @Value("\${spring.application.name}")
    private val title: String,

    @Value("\${spring.application.description}")
    private val description: String,

    @Value("\${spring.application.version}")
    private val version: String,

    ) : WebMvcConfigurer {

    @Bean
    fun productApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.br.rank.list.infra"))
            .build()
            .tags(
                Tag("Search", "")
            )
            .apiInfo(metaData())
    }

    private fun metaData(): ApiInfo? {
        return ApiInfoBuilder()
            .title(title.uppercase())
            .description(description)
            .version(version)
            .contact(contact())
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .build()
    }

    private fun contact(): Contact? {
        return Contact(
            "Leonardo Rodrigues Dantas",
            "https://www.linkedin.com/in/leonardo-rodrigues-dantas/",
            "leonardordnt1317@gmail.com"
        )
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }
}