package hello;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import custom.CustomCacheManager;
import custom.CustomCacheResolver;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

	@Bean
	public CacheManager cacheManager() {
		CustomCacheManager cacheManager = new CustomCacheManager();
		return cacheManager;
	}
	
	@Bean
	public CacheResolver cacheResolver() {
		CacheManager cacheManager = this.cacheManager();
		CustomCacheResolver cacheResolver = new CustomCacheResolver(cacheManager);
		return cacheResolver;
	}
}
