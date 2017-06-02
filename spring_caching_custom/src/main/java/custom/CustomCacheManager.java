package custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.util.StringUtils;

public class CustomCacheManager extends AbstractCacheManager {

	@Value("${cache.name.prefix}")
	private String cacheNamePrefix;
	
	@Override
	protected Collection<? extends Cache> loadCaches() {
		List<Cache> caches = new ArrayList<>();
		return caches;
	}

	@Override
	protected Cache getMissingCache(String name) {
		String cacheName =
				StringUtils.isEmpty(cacheNamePrefix) ? name : String.format("%s:%s", cacheNamePrefix, name);
		return new CustomCache(cacheName);
	}

}
