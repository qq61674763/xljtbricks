package com.bricks.controller.login;

import com.bricks.common.result.ResultCodeEnum;
import com.bricks.common.result.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(tags = "登录/登出")
public class Login {

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResultResponse login() throws InterruptedException {
        return new ResultResponse(ResultCodeEnum.succeed,null);
    }

    @GetMapping("/loginOut")
    @ApiOperation(value = "登出")
    public ResultResponse loginOut() {
        return new ResultResponse(ResultCodeEnum.succeed,null);
    }

}
