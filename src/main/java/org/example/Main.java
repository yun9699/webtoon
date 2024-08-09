package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //bad code
    public static void main(String[] args) throws Exception {

        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();

    }
}