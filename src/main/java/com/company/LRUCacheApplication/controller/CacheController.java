package com.company.LRUCacheApplication.controller;

import com.company.LRUCacheApplication.entity.Cache;
import com.company.LRUCacheApplication.service.CacheService;
import com.company.LRUCacheApplication.service.LruCacheService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    private final CacheService cacheService;

    private final LruCacheService lruCacheService;

    public CacheController(CacheService cacheService, LruCacheService lruCacheService) {
        this.cacheService = cacheService;
        this.lruCacheService = lruCacheService;
    }

    @PostMapping
    public ResponseEntity<Cache> saveCache(@Valid @RequestBody Cache cache) {
        Cache savedCache = cacheService.saveCache(cache);
         return ResponseEntity.status(200).body(savedCache);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Object> get(@PathVariable String key) {
        return cacheService.getBeyKey(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<Void> delete(@PathVariable String key) {
        return lruCacheService.evict(key)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public void delete() {
        cacheService.delete();
    }
}
