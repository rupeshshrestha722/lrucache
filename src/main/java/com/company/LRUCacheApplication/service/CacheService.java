package com.company.LRUCacheApplication.service;

import com.company.LRUCacheApplication.entity.Cache;

import java.util.List;
import java.util.Optional;

public interface CacheService {
    Cache saveCache(Cache cache);
    Optional<Object> getBeyKey(String key);
    void delete(String key);
    void delete();
    List<Cache> getAll();
}
