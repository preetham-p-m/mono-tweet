package com.pmp.restful_web_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pmp.restful_web_service.model.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
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
