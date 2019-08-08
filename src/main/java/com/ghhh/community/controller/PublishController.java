package com.ghhh.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author galaxy
 * @date 19-8-8 - 下午8:07
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish()
    {
        return "publish";
    }
}
