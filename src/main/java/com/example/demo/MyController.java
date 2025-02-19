package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MyController {

    @Autowired
    // 指定要注入的bean
    @Qualifier("hpPrinter")
    private Printer printer;

    @RequestMapping("/test")
    public String test() {
        printer.print("Hello world");
        return "hello world";
    }
    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        store.setProductList(list);
        return store;
    }
//    @RequestMapping("/user")
//    public Student user() {
//        Student student = new Student();
//        student.setName("John");
//        return student;
//    }
}