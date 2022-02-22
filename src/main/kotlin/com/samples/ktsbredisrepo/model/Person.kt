package com.samples.ktsbredisrepo.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Person")
class Person(@Id var personID: String, var name: String, var emailID: String)