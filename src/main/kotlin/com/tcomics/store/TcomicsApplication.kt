package com.tcomics.store

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TcomicsApplication

fun main(args: Array<String>) {
    runApplication<TcomicsApplication>(*args)
}
