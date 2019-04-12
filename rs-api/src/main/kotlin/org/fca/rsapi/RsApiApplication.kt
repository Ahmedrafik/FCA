package org.fca.rsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsApiApplication

fun main(args: Array<String>) {
    runApplication<RsApiApplication>(*args)
}

