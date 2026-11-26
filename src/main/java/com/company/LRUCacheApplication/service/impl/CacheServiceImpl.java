package com.company.LRUCacheApplication.service.impl;

import com.company.LRUCacheApplication.entity.Cache;
import com.company.LRUCacheApplication.repository.CacheRepository;
import com.company.LRUCacheApplication.service.CacheService;
import com.company.LRUCacheApplication.service.LruCacheService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CacheServiceImpl implements CacheService {
    private final LruCacheService cacheService;

    private final CacheRepository cacheRepository;

    public CacheServiceImpl(CacheRepository cacheRepository, LruCacheService lruCacheService) {
        this.cacheRepository = cacheRepository;
        this.cacheService = lruCacheService;
    }

    @Override
    public Cache saveCache(Cache cache) {
        Cache cache1 = new Cache();
        cache1.setKey(cache.getKey());
        cache1.setValue(cache.getValue());
        cacheService.put(cache.getKey(), cache.getValue());
        return cacheRepository.save(cache1);
    }

    @Override
    public Optional<Object> getBeyKey(String key) {
        Optional<Object> cache = cacheService.get(key);
        if (!cache.isPresent()) {
            return null;
        }
        return cache;
    }

    @Override
    public void delete(String key) {
        Cache cache = cacheRepository.findByKey(key);
        cacheRepository.delete(cache);
    }

    @Override
    public void delete() {
        cacheRepository.deleteAll();
    }

    @Override
    public List<Cache> getAll() {
        return cacheRepository.findAll();
    }
}
