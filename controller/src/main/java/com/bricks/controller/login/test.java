package com.bricks.controller.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XU
 * @program bricks
 * @description todo
 * @create 2020/6/5
 */
@RestController
public class test {

    @GetMapping("aa")
    public String a() {
        return "aaaaa";
    }

}
