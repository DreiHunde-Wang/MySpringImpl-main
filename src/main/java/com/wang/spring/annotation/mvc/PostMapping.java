package com.wang.spring.annotation.mvc;


import com.wang.spring.annotation.core.AliasFor;
import com.wang.spring.constants.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@RequestMapping(method = RequestMethod.POST)
public @interface PostMapping {
    @AliasFor(annotation = RequestMapping.class)
    String value() default "null";

    @AliasFor(annotation = RequestMapping.class)
    RequestMethod method() default RequestMethod.POST;
}
