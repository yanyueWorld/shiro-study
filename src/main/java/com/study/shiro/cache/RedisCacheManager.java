package com.study.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * RedisCacheManager .
 *
 * @author yanyue, 2019/6/20
 * @version shiro v1.0
 */
public class RedisCacheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
