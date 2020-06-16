package com.bricks.controller.aspect;

import com.alibaba.fastjson.JSON;
import com.bricks.pojo.log.ControllerLogDO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Log aspect.
 *
 * @author XU
 * @date 2020.06.01
 * @program bricks
 * @description todo
 * @create 2020 /5/22
 */
@Component
@Aspect
@Order(100)
@Slf4j
public class LogAspect {

    @Pointcut(value = "execution(* com.bricks.controller..*(..))&&" +
            "!execution(* com.bricks.controller.aspect..*(..))&&" +
            "!execution(* com.bricks.controller.security..*(..))&&" +
            "!execution(* com.bricks.controller.swagger..*(..))")
    public void controllerLog() {
    }

    /**
     * Do around object.
     *
     * @param joinPoint the join point
     * @return the object
     * @author xu
     * @date 2020.05.29
     */
    @Around("controllerLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        // 获取请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        // 获取请求信息
        ControllerLogDO requestInfo = getRequestInfo(requestAttributes);

        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long spendTime = System.currentTimeMillis() - startTime;
            requestInfo.setSpendTime(spendTime);
            // 输出LOG日志
            consoleLog(requestInfo);
            // 保存日志到数据库
            Integer integer = saveLogToDb(requestInfo);
        }
        return result;
    }

    /**
     * 获取请求信息
     * Gets request info.
     *
     * @param requestAttributes the request attributes
     * @return the request info
     * @author xu
     * @date 2020.06.01
     */
    private ControllerLogDO getRequestInfo(ServletRequestAttributes requestAttributes) {
        HttpServletRequest request = requestAttributes.getRequest();

        ControllerLogDO controllerLogDO = new ControllerLogDO();
        controllerLogDO.setIp(request.getRemoteAddr());
        controllerLogDO.setParams(JSON.toJSON(request.getParameterMap()).toString());
        controllerLogDO.setUri(request.getRequestURI());
        controllerLogDO.setId("");
        return controllerLogDO;
    }

    /**
     * 存储LOG日志到数据库
     * Save log to db integer.
     *
     * @param controllerLogDO the controller log do
     * @return the integer
     * @author xu
     * @date 2020.06.01
     */
    private Integer saveLogToDb(ControllerLogDO controllerLogDO) {
        return null;
    }

    /**
     * 输出日志信息
     * Console log.
     *
     * @param requestInfo the request info
     * @author xu
     * @date 2020.06.01
     */
    private void consoleLog(ControllerLogDO requestInfo) {
        log.warn("IP:" + requestInfo.getIp() + " URI:" + requestInfo.getUri()
                + " Params:" + requestInfo.getParams() + " SpendTime:" + requestInfo.getSpendTime());
    }
}
