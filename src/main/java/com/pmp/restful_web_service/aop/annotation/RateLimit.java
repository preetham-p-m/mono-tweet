package com.pmp.restful_web_service.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimit {

    int limit() default 5;

    long duration() default 60 * 1000; // Converting to Milliseconds

}
