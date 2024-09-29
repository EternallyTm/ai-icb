package com.icb.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public ReactiveRedisTemplate<String, Object> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveRedisTemplate<>(
            factory,
            RedisSerializationContext.<String, Object>newSerializationContext()
                .key(new StringRedisSerializer())
                .value(new GenericToStringSerializer<>(Object.class))
                .hashKey(new StringRedisSerializer())
                .hashValue(new GenericToStringSerializer<>(Object.class))
                .build()
        );
    }
}
