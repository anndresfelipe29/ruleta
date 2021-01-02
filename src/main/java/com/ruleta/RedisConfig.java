package com.ruleta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {	
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("172.17.0.1", 6379);
	    redisStandaloneConfiguration.setPassword(RedisPassword.of(""));
	    return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	
	  @Bean
	  public RedisTemplate<String, Object> redisTemplate() {
	    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(redisConnectionFactory());
	    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	    return template;
	  }

}