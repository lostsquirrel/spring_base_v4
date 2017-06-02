package custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.AbstractValueAdaptingCache;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * a unsafe cache implements
 */
public class CustomCache extends AbstractValueAdaptingCache implements Cache {

	private final static Logger log = LoggerFactory.getLogger(CustomCache.class);

	private String name;

	private HashMap<Object, Object> cache = new HashMap<>();

	public CustomCache(String name) {
		super(true);
		this.name = name;
		log.debug("create CustomCache {}", name);
	}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return cache;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return (T) cache.get(key);
    }

    @Override
    public void put(Object key, Object value) {
        cache.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        if (!cache.containsKey(key)) {
            this.put(key, value);
        }
        return this.get(key);
    }

    @Override
    public void evict(Object key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }


    @Override
    protected Object lookup(Object key) {
        return cache.get(key);
    }
}
