package com.felix.redis.controller;

import com.felix.redis.util.CommonUtil;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-08-06 22:44
 */
@RestController
@RequestMapping("api/v1/captcha")
public class CaptchaController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Qualifier("captchaProducer")
    @Autowired
    private Producer captchaProducer; //  根据名称注入

    @GetMapping("get_captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
        String text = captchaProducer.createText();
        String captchaKey = getCaptchaKey(request);
        //10分钟过期
        redisTemplate.opsForValue().set(captchaKey,text, 10,TimeUnit.MINUTES);

        BufferedImage image = captchaProducer.createImage(text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private String getCaptchaKey(HttpServletRequest request){
        String ip = CommonUtil.getIpAddr(request);
        String header = request.getHeader("User-Agent");
        String key = "user-service:captcha:" + CommonUtil.MD5(ip+header);
        return key;
    }
}
