package custom;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.AbstractCacheResolver;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheableOperation;

public class CustomCacheResolver extends AbstractCacheResolver {

	public CustomCacheResolver(CacheManager cacheManager) {
		super(cacheManager);
	}
	
	@Override
	protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> context) {
		Set<String> cacheNames = context.getOperation().getCacheNames();
		return cacheNames;
	}

}
