package com.bricks.controller.aspect;

import java.lang.annotation.*;

/**
 * The interface Controller web log.
 *
 * @author xu
 * @date 2020.05.22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    String name();
    boolean intoDb() default false;
}
