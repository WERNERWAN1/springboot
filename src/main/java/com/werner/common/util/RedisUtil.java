package com.werner.common.util;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: RedisUtil 
 * @Description: TODO redis管理工具
 * @author: hayder
 * @date: 2017年10月10日 下午3:08:07  
 */
@Component
public class RedisUtil {
	private static Logger logger = Logger.getLogger(RedisUtil.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 删除对应的value
	 * @param key
	 */
	public void remove(final String key) throws Exception{
		if (exists(key)) {
			stringRedisTemplate.delete(key);
		}
	}
	
	/**
	 * 判断缓存中是否有对应的value
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) throws Exception {
		return stringRedisTemplate.hasKey(key);
	}
	
	/**
	 * 读取缓存
	 * @param key
	 * @return
	 */
	public String get(final String key) {
		String result = null;
		try {
			ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
			result = operations.get(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	/**
	 * 写入缓存
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean set(final String key, String value) {
		boolean result = false;
		try {
			ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	/**
	 * 写入缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, String value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
			operations.set(key, value);
			stringRedisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	

	public Long increment(final String key, final long delta) {
		Long result = null;
		try {
			ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
			result = operations.increment(key, delta);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = null;
		}
		return result;
	}
	
	public boolean expireTime(final String key, Long expireTime){
		boolean bool = false;
		try {
			Boolean b = stringRedisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			if (null != b && b.booleanValue()){
				bool = b.booleanValue();
			}else{
				bool = false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			bool = false;
		}
		return bool;
	}
	
	public StringRedisTemplate getRedisTemplate() {
		return stringRedisTemplate;
	}
}
