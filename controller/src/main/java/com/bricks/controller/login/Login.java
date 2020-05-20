package com.bricks.controller.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XU
 * @program bricks
 * @description todo
 * @create 2020/5/20
 */
@RestController
public class Login {

    @GetMapping("/login")
    public String login() {
        return "登录";
    }

    @GetMapping("/loginOut")
    public String loginOut() {
        return "注销";
    }

}
