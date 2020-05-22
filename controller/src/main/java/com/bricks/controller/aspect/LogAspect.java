package com.bricks.controller.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author XU
 * @program bricks
 * @description todo
 * @create 2020/5/22
 */
@Component
@Aspect
@Order(100)
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.bricks.controller..*(..))")
    public void controllerLog(){
    };

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        StringBuilder logMsg = new StringBuilder();
        return;
    }
}
