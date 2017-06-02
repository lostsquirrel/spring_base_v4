package custom;

import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;

public class CustomCache extends ConcurrentMapCache implements Cache {
	
	public CustomCache(String name) {
		super(name);
	}
}
