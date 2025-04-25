package com.example.routes

import org.apache.camel.builder.RouteBuilder
import org.springframework.context.annotation.Configuration


@Configuration
class HelloRoute: RouteBuilder() {
    override fun configure() {
//        from("timer:hello?period=1s").log("hello")
    }
}