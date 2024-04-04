package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class HazelcastPlaygroundApplication

fun main(args: Array<String>) {
	runApplication<HazelcastPlaygroundApplication>(*args)
}
