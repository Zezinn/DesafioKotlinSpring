package com.wswork.apikotlin.desafio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("repository")
@ComponentScan(basePackages = ["com.wswork.apikotlin.desafio", "config", "controller", "service"])
@EntityScan("model")
class DesafioApplication

fun main(args: Array<String>) {
	runApplication<DesafioApplication>(*args)
}
