package com.cn.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Redis工具类,为了方便操作redis
 */
@Component

public class RedisUtils {

	@Autowired
	RedisTemplate<Object,Object> redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;



	/**
	 * redis 的 list数据类型，不断的往左进行追加
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean rpush(String key,String value){
		try {
			redisTemplate.opsForList().rightPush(key, value);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 操作 redis 的list 类型数据，从左往右取出 list中的value
	 * @param key
	 * @return
	 */
	public Object lpop(String key){
		return redisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 操作 redis 的list 类型数据，取出 list中的所有的value
	 * @param key
	 * @return
	 */
	public List listAll(String key){
		return redisTemplate.opsForList().range(key,0,-1);
	}

	/**
	 * 通用方法 根据key删除对应的value
	 * @param key
	 */
	public void del(String ... key){
		redisTemplate.delete(Stream.of(key).collect(Collectors.toList()));
	}

	/**
	 * 操作 redis 的list类型数据，删除已有value
	 * @param key
	 * @param value
	 * @return
	 */
	public Long lrem(String key,String value){
		return redisTemplate.opsForList().remove(key,0,value);
	}

}
