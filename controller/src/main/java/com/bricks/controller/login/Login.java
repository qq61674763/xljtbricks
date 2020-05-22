package com.bricks.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XU
 * @program bricks
 * @description todo
 * @create 2020/5/20
 */
@RestController
@Slf4j
public class Login {

    @PostMapping("/login")
    public String login() {
        log.debug("调试登录");
        log.info("登录");
        return "登录";
    }

    @GetMapping("/loginOut")
    public String loginOut() {
        log.warn("登出");
        log.error("异常登出");
        return "注销";
    }

}
