package com.felix.redis.service.Impl;

import com.felix.redis.dao.VideoCardDao;
import com.felix.redis.model.VideoCardDO;
import com.felix.redis.service.VideoCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-07 12:15
 */
@Service
public class VideoCardServiceImpl implements VideoCardService {

    @Autowired
    private VideoCardDao videoCardDao;

    @Override
    public List<VideoCardDO> list() {
        return videoCardDao.list();
    }
}
