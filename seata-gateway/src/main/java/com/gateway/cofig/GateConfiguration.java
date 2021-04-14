package com.gateway.cofig;

//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import reactor.core.publisher.Mono;

/**
 * @author xiaojw
 * @describe Configuration
 * @date 2021/4/13 14:16
 */
//@Configuration
public class GateConfiguration {

//
//    @Bean
//    public StringRedisTemplate redisTemplate() {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate();
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setConnectionFactory(standaloneConnectionFactory("127.0.0.1", 6379));
//        return redisTemplate;
//    }
//
//    public JedisConnectionFactory standaloneConnectionFactory(String host, int port) {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName(host);
//        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setDatabase(15);
//        redisStandaloneConfiguration.setPassword("W&B7#!@Vinv*Za!U");
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }
//
//    @Bean(value = "ipKeyResolver")
//    public KeyResolver ipKeyResolver() {
//        return exchange -> {
//            return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//        };
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        // KeySerializer
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        // ValueSerializer
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.findAndRegisterModules();
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//        // redisTemplate
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//        template.setKeySerializer(stringSerializer);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(stringSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        // return bean
//        return template;
//    }
}
