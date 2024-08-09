package org.example.controller;

import org.example.anno.Controller;
import org.example.anno.WebPath;

@WebPath("/menu")
public class MenuController {

    @Controller("/list")
    public void menuList(){
        System.out.println("menu list");
    }
}