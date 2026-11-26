package com.company.LRUCacheApplication.repository;

import com.company.LRUCacheApplication.entity.Cache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CacheRepository extends JpaRepository<Cache, Long> {

    Cache findByKey(String key);
}
