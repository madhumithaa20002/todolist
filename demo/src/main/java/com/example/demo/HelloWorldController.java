package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean getMessage()
    {
        return new HelloWorldBean("Hello from bean-Changed");
        //throw new RuntimeException("Some error occured");
    }

    @GetMapping(path="/hello-world-bean/pathvariable/{name}")
    public HelloWorldBean getMessage_pathvaribale(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello from bean-Changed,%s",name));
        //throw new RuntimeException("Some error occured");
    }


}
