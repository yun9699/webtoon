package org.example.controller;

import org.example.anno.Controller;
import org.example.anno.WebPath;

@WebPath("/user")
public class UserController {

    @Controller("/list")
    public void listUP(){
        System.out.println("USer list up....");
    }
}