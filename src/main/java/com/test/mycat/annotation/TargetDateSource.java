package com.test.mycat.annotation;

/**
 * @Auther: huang
 * @Date: 2019/6/18 14:53
 * @Description:
 */

import java.lang.annotation.*;

/**
 * 切换数据注解 可以用于类或者方法级别 方法级别优先级 > 类级别
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDateSource {

    String value() default "master"; //该值即key值

}