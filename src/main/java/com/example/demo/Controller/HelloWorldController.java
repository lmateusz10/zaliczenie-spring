package com.example.demo.Controller;

import com.example.demo.HelloBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello wordl";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloBean helloBean(){
        return new HelloBean("Hello world");
    }
}
