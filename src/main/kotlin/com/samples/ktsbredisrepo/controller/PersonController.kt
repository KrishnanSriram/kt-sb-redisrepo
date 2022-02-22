package com.samples.ktsbredisrepo.controller

import com.samples.ktsbredisrepo.config.RedisConfig
import com.samples.ktsbredisrepo.model.Person
import com.samples.ktsbredisrepo.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.math.log

@RestController
@RequestMapping("/person")
class PersonController(val repository: PersonRepository) {
    companion object {
        val logger = LoggerFactory.getLogger(PersonController::class.java)
    }

    @PostMapping()
    fun addPerson(@RequestBody person: Person): ResponseEntity<String> {
        logger.info("Add NEW person")
        repository.save(person)
        return ResponseEntity("Saved person - ${person.personID}", HttpStatus.CREATED)
    }

    @GetMapping()
    fun allPeople(): ResponseEntity<MutableIterable<Person>> {
        logger.info("List ALL people")
        val people = repository.findAll()
        return ResponseEntity(people, HttpStatus.OK)
    }
}