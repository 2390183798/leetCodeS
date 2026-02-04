package org.dodo.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 注解在运行时保留
@Target(ElementType.TYPE) // 注解用于类、接口（包括注释类型）或枚举声明
public @interface ClassNum {
    int value() default 0; // 定义一个属性，带有默认值
}