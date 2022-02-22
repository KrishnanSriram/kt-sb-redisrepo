package com.samples.ktsbredisrepo.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class RedisConfig(val env: Environment) {
    companion object {
        val logger = LoggerFactory.getLogger(RedisConfig::class.java)
    }
    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        logger.info("Create JedisConnectionFactory")
        val jedis = JedisConnectionFactory()
        jedis.hostName = env.getProperty("spring.redis.host").toString()
        jedis.port = env.getProperty("spring.redis.port")?.toInt() ?: 6379
        jedis.afterPropertiesSet()
        return jedis
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Object> {
        logger.info("Create redisTemplate")
        var template = RedisTemplate<String, Object>()
        template.setConnectionFactory(jedisConnectionFactory())
        return template
    }
}