package com.wegame.controller;

import com.wegame.config.BaseController;
import com.wegame.service.FriedFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName：StartController
 * @Description: 启动类
 * @Author：13738700108
 * @Data 2020/10/6 18:59
 * @Version: v1.0
 **/

@Component
public class StartController extends BaseController {

    @Autowired
    private FriedFlowerService ffs;

    @PostConstruct
    public void cleanSeatUser(){
        LOGGER.info("------------------开始执行清理桌子用户----------------------");
        ffs.updateSeatUser();
        LOGGER.info("------------------清理桌子用户结束----------------------");
    }
}
