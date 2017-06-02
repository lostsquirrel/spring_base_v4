package custom;

import java.util.Collection;
import java.util.Set;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.AbstractCacheResolver;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;

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
