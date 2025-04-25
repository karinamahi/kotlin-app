package com.example

import com.example.models.Book
import com.example.repository.BookRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@ExtendWith(SpringExtension::class)
@SpringBootTest
class BookTest {

    companion object {
        @Container
        val postgres = PostgreSQLContainer<Nothing>("postgres:14-bullseye").apply {
            withDatabaseName("testdb")
            withUsername("test")
            withPassword("test")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
            registry.add("spring.datasource.username", postgres::getUsername)
            registry.add("spring.datasource.password", postgres::getPassword)
        }
    }

    @Autowired
    lateinit var context: ApplicationContext

    @Autowired
    lateinit var repository: BookRepository

    @Test
    fun test() {
        Assertions.assertNotNull(context)

        repository.save(Book().apply {
            title = "New Book"
            publisher = "New Publisher"
            subtitle = "New Subtitle"
        })

        repository.findAll().forEach {
            println("book.id: - ${it.id}")
        }
    }
}