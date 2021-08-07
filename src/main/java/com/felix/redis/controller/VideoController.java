package com.felix.redis.controller;

import com.felix.redis.model.VideoCardDO;
import com.felix.redis.model.VideoDO;
import com.felix.redis.service.VideoCardService;
import com.felix.redis.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-07 11:27
 */
@RestController
@RequestMapping("/api/v1/card")
public class VideoController {
    @Autowired
    private VideoCardService videoCardService;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String VIDEO_CARD_CACHE_KEY = "video:card:key";
    /*
    * @Description: 无缓存
    * @Author: Mr.Felix
    * @Time: 2021/8/7
    **/
    @GetMapping("list_cache")
    public JsonData listCardCache(){
        Object o = redisTemplate.opsForValue().get(VIDEO_CARD_CACHE_KEY);
        if (o != null){
            List<VideoCardDO> list = (List<VideoCardDO>)o;
            return JsonData.buildSuccess(list);
        }else{
            List<VideoCardDO> list = videoCardService.list();
            redisTemplate.opsForValue().set(VIDEO_CARD_CACHE_KEY,list, 10,TimeUnit.MINUTES);
            return JsonData.buildSuccess(list);
        }
    }

    /*
    * @Description: 无缓存
    * @Author: Mr.Felix
    * @Time: 2021/8/7
    **/
    @GetMapping("list_nocache")
    public JsonData listCardNoCache(){
        List<VideoCardDO> list = videoCardService.list();
        return JsonData.buildSuccess(list);
    }
}
