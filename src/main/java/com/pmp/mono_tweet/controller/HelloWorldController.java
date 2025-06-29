package com.pmp.mono_tweet.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pmp.mono_tweet.model.HelloWorld;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

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
        return new HelloWorld("Hello World, %s".formatted(name));
    }

}
