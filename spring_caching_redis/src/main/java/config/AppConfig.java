package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class AppConfig {

	/**
     * Type safe representation of application.properties
     */
    @Autowired ClusterConfigurationProperties clusterProperties;

    public @Bean RedisConnectionFactory connectionFactory() {

        return new JedisConnectionFactory(
            new RedisClusterConfiguration(clusterProperties.getNodes()));
    }
    
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
      RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
      redisTemplate.setKeySerializer(new StringRedisSerializer());
      redisTemplate.setConnectionFactory(cf);
      return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
      RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

      // Number of seconds before expiration. Defaults to unlimited (0)
//      cacheManager.setDefaultExpiration(300);
      return cacheManager;
    }
}
