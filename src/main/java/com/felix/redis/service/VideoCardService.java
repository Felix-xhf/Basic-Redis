package com.felix.redis.service;

import com.felix.redis.model.VideoCardDO;

import java.util.List;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-07 12:14
 */
public interface VideoCardService {
    List<VideoCardDO> list();
}
