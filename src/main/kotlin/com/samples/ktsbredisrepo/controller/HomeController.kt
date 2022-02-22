package com.samples.ktsbredisrepo.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HomeController{
    companion object {
        val logger = LoggerFactory.getLogger(HomeController::class.java)
    }

    @GetMapping()
    fun home(): ResponseEntity<String> {
        logger.info("HOME invoked")
        return ResponseEntity<String>("Hello, Welcome to Redis Ops", HttpStatus.OK)
    }
}