package com.felix.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-07 11:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDO {
    private Integer id;
    private String title;
    private String img;
    private Integer price;
}
