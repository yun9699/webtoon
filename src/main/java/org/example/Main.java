package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //bad code
    public static void main(String[] args) throws Exception{


        Document doc = Jsoup.connect("https://comic.naver.com/webtoon/detail?titleId=814543&no=52&week=tue").get();

        //System.out.println(doc);

        Elements viewer = doc.select(".wt_viewer img");

        //System.out.println(viewer);

        for (Element element : viewer) {

            String imgSrc = element.attr("src");

            System.out.println(imgSrc);

            String fileName = imgSrc.substring(imgSrc.lastIndexOf("/")+1);


            URLConnection urlConnection = new URL(imgSrc).openConnection();

            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36");

            InputStream inputStream = urlConnection.getInputStream();

            OutputStream outputStream = new FileOutputStream("C:\\zzz\\"+fileName);

            byte[] buffer = new byte[1024*8];

            while (true){
                int count = inputStream.read(buffer);
                if(count == -1){ break;}
                outputStream.write(buffer,0,count);
            }//end while

            inputStream.close();
            outputStream.close();

        }//end for


    }
}