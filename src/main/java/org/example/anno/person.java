package org.example.anno;

@BGM(song = "Spring")
public class Person {

    @BGM(song = "We are the champion")
    public void go(){
        System.out.println("go");
    }

    @BGM(song = "Remember me")
    public void back() {
        System.out.println("back");
    }
}