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

public class CGVMovies {

    public static void main(String[] args)throws Exception {

        Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();

        //System.out.println(doc);

        Elements elements = doc.select(".sect-movie-chart ol li");

        for (Element element : elements) {

            //System.out.println(element);
            System.out.println("------------------------------");

            Elements imgEles = element.select(".thumb-image img");

            for (Element imgElement : imgEles) {

                String imageUrl = imgElement.attr("src");

                System.out.println(imageUrl);

                URL url = new URL(imageUrl);
                InputStream in = url.openStream();

                String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

                OutputStream out = new FileOutputStream("C:\\zzz\\"+fileName);

                byte[] buffer = new byte[1024];

                while (true){
                    int len = in.read(buffer);
                    if (len == -1){break;}
                    out.write(buffer,0,len);
                }//end while

                in.close();
                out.close();


            }//end for
        }//end for
    }//end main
}