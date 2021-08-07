package com.felix.redis;

import com.felix.redis.model.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

@SpringBootTest
class RedisApplicationTests implements Serializable {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    void contextLoads() {
//        ValueOperations valueOperations = redisTemplate.opsForValue();

        redisTemplate.opsForValue().set("redis","class");

        stringRedisTemplate.opsForValue().set("StringRedis","StringRedis");

    }

    @Test
    void testStringGet(){
        /*
        * 把对象变为字节序列的过程称为对象的序列化
        * 把字节序列恢复成对象的过程称为对象的反序列化
        * 序列化的用途：1.将对象永久保存到硬盘上，2.在网络上传送对象的字节序列
        * */
        String str = (String) redisTemplate.opsForValue().get("redis");
        System.out.println(str);

        String str2 = stringRedisTemplate.opsForValue().get("redis");
        System.out.println(str2);
    }

    @Test
    void testSeria(){
        UserDO userDO = new UserDO();
        userDO.setId(3);
        userDO.setPwd("二当家");
        userDO.setPwd("123");
        redisTemplate.opsForValue().set("user-service:user:3",userDO);
    }

}
