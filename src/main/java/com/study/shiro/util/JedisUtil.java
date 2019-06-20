package com.study.shiro.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/6/20
 * @version shiro v1.0
 */

@Component
public class JedisUtil {

    @Autowired
    private JedisPool jedisPool;

    private Jedis getResource(){
        return jedisPool.getResource();
    }

    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis=getResource();
        try {
            jedis.set(key,value);
            return value;
        } finally {
            jedis.close();
        }
    }

    public void expire(byte[] key, int value) {
        Jedis jedis=getResource();
        try {
            jedis.expire(key,value);
        } finally {
            jedis.close();
        }
    }

    public byte[] get(byte[] key) {
        Jedis jedis=getResource();
        try {
            return jedis.get(key);
        } finally {
            jedis.close();
        }
    }

    public void del(byte[] key) {
        Jedis jedis=getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    public Set<byte[]> keys(String shiro_session_perfix) {
        Jedis jedis=getResource();
        try {
            return jedis.keys((shiro_session_perfix+"*").getBytes());
        } finally {
            jedis.close();
        }
    }
}
