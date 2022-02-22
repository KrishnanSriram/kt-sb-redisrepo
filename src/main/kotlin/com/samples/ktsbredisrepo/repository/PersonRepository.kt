package com.samples.ktsbredisrepo.repository

import com.samples.ktsbredisrepo.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository: CrudRepository<Person, String> {}