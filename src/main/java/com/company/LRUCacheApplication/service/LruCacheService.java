package com.company.LRUCacheApplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LruCacheService {

    @Value("${cache.capacity}")
    private int MAX_CAPACITY;

    private final Map<String, Object> cache;

    public LruCacheService() {

        this.cache = new LinkedHashMap<>(MAX_CAPACITY, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size() > MAX_CAPACITY;
            }
        };
    }

    public synchronized Optional<Object> get(String key) {
        return Optional.ofNullable(cache.get(key));
    }



    public synchronized void put(String key, Object value) {
        cache.put(key, value);
    }

    public synchronized boolean evict(String key) {
        return cache.remove(key) != null;
    }

    public Map<String, Object> getAll() {
            return new LinkedHashMap<>(cache);
    }
}
