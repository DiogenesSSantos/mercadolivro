package com.github.diogenesssantos.mercadolivro.controller

import ch.qos.logback.core.util.ContentTypeUtil
import jakarta.servlet.ServletOutputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jdk.jfr.ContentType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.temporal.Temporal
import java.time.temporal.TemporalAmount
import java.time.temporal.TemporalUnit
import java.util.Date
import java.util.Locale
import kotlin.time.Duration.Companion.days


@RestController
@RequestMapping(path = ["/index"])
class MainSpringController {

    companion object {
        private val log: Logger = LoggerFactory.getLogger("MainController")
    }

    @GetMapping
    fun index(): ResponseEntity<Any> {
        log.warn("MÉTODO INDEX CHAMADO na porta")
        return ResponseEntity.ok("Index VAMUUUU")
    }

    @PostMapping
    fun salvar(usuario: String?, resposta : HttpServletResponse): ResponseEntity<Any> {
        log.warn("SALVADO COM SUCESSO")


        var data = Date()
        resposta.addDateHeader("Dioge", Instant.now().epochSecond.plus(784564))
        resposta.locale = Locale.CHINA
        var outPut = resposta.outputStream
        outPut.print("Diogenes")





        return ResponseEntity.status(HttpStatus.CREATED)
            .build()
    }


}