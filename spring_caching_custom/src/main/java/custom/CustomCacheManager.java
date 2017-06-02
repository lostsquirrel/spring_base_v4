package custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

public class CustomCacheManager extends AbstractCacheManager {

	
	@Override
	protected Collection<? extends Cache> loadCaches() {
		
		
		List<Cache> caches = new ArrayList<>();
		for (String cacheName : super.getCacheNames()) {
			CustomCache cache = new CustomCache(cacheName);
			caches.add(cache);
			System.out.println(String.format("create cache name:%s", cacheName));
		}
		return caches;
	}

}
