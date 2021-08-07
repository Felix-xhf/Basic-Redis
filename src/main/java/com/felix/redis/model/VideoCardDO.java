package com.felix.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-07 11:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoCardDO {
    private String title;
    private Integer id;
    private Integer weight;
    List<VideoDO> list;
}
