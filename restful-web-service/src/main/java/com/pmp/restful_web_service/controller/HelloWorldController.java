package com.pmp.restful_web_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pmp.restful_web_service.model.HelloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWorldController {

    MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        super();
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/hello-i18n")
    public String helloUserI18n() {
        Locale locale = LocaleContextHolder.getLocale();
        return this.messageSource.getMessage("hello.message", null,
                "The message will be displayed if the key is not present in the default language", locale);
    }

    @GetMapping("/hello-world")
    public HelloWorld helloWorld() {
        return new HelloWorld("Hello World");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorld getMethodName(@PathVariable String name) {
        return new HelloWorld(String.format("Hello World, %s", name));
    }

}
