package com.felix.redis.dao;

import com.felix.redis.model.VideoCardDO;
import com.felix.redis.model.VideoDO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-07 11:28
 */
@Repository
public class VideoCardDao {
    public List<VideoCardDO> list(){
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<VideoCardDO> cardDOList = new ArrayList<>();


        VideoDO videoDO1 = new VideoDO(1,"SpringCloud","xdclass.net",1000);
        VideoDO videoDO2 = new VideoDO(2,"SpringBoot","xdclass.net",2000);
        VideoDO videoDO3 = new VideoDO(3,"SpringMVC","xdclass.net",3000);
        VideoDO videoDO4 = new VideoDO(4,"Spring源码","xdclass.net",4000);

        VideoCardDO videoCardDO1 = new VideoCardDO();
        videoCardDO1.setId(1);
        videoCardDO1.setTitle("热门视频");

        List<VideoDO> videoDOS = new ArrayList<>();
        videoDOS.add(videoDO1);
        videoDOS.add(videoDO2);
        videoDOS.add(videoDO3);
        videoDOS.add(videoDO4);

        videoCardDO1.setList(videoDOS);

        cardDOList.add(videoCardDO1);
        return cardDOList;
    }
}
