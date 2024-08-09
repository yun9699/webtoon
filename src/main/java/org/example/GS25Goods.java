package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;

public class GS25Goods {

    //bad code
    public static void main(String[] args) throws Exception {

        String path = "http://gs25.gsretail.com/gscvs/ko/products/event-goods";

        Document doc = Jsoup.connect(path).get();

        //CSRFTOKEN
        //System.out.println(doc);

        String token = doc.select("#CSRFForm").get(0).select("input[name='CSRFToken']").get(0).attr("value");

        System.out.println(token);

        //POST방식으로 행사상품 조회

        HashMap<String, String> params = new HashMap<>();
        params.put("pageNum", "1");
        params.put("pageSize", "8");
        params.put("parameterList", "ONE_TO_ONE");

        String target = "http://gs25.gsretail.com/gscvs/ko/products/event-goods-search?CSRFToken="+token;


        Connection.Response response = Jsoup.connect(target)
                .method(Connection.Method.POST)
                .data(params)
                .header("Cookie","JSESSIONID=DA280F55F2325D618D9345FE14C32835.htomcat1; _BS_GUUID=Oe2bCEgp4KCjl4so4UGQcgqxX9afWRSK6UWIyc8D; __utmz=252352415.1714830047.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); _ga=GA1.1.618084500.1714830048; JSESSIONID=DA280F55F2325D618D9345FE14C32835.htomcat1; _TRK_EX32670=1; _TRK_CQ32670=%3Fuiel=Mobile; __utma=252352415.1181417672.1714830047.1721349008.1723180139.3; __utmc=252352415; __utmb=252352415.1.10.1723180139; _TRK_UID=0214e788895df4ab9a33d002030eeada:1:0.00006836805555555555:1723180144499; _ga_CHSRECZ6BZ=GS1.1.1723180138.3.1.1723180522.60.0.0; _TRK_EX22400=8; _TRK_SID=b4f558c14dff2b4d32be3cf5b800e49e")
                .header("Origin","http://gs25.gsretail.com")
                .header("Referer","http://gs25.gsretail.com/gscvs/ko/products/event-goods")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36") // 헤더 설정
                .header("Content-Type", "application/x-www-form-urlencoded") // 헤더 설정
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 헤더 설정
                .execute();

        Document document = response.parse();

        System.out.println(document);

    }//end main
}//end class