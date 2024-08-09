package org.example.controller;

import org.example.anno.Controller;
import org.example.anno.WebPath;

@WebPath("/todo")
public class TodoController {

    @Controller("/list")
    public void list(){
        System.out.println("todo list");
    }

    @Controller("/add")
    public void register(){
        System.out.println("todo register");
    }

    @Controller("/remove")
    public void delete(){
        System.out.println("todo delete");
    }
}