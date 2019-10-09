package com.zhku.mh.main;

import com.zhku.mh.util.URLFecter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;
import java.net.URL;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-09 14:12
 */
public class DemoMain {
    static final Log logger = LogFactory.getLog(DemoMain.class);

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClients.createDefault();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
        String strUrl = "http://agr.cnjson.com/FruitTreeExpert/pagea1_3_1.aspx?FClassID=1000&&FClassName=%c0%f3%d6%a6&&MenoID=1000&&MenoName=1%d4%c2%a3%a8%d0%a1%ba%ae%a1%ab%b4%f3%ba%a";
        URL url = new URL(strUrl);
        URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
        //抓取的数据
        String html = URLFecter.URLParser(client, uri.toString());
        logger.info(html);
        System.out.println("----  "+html);
        System.out.println("end");
    }
}
