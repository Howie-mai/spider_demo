package com.zhku.mh.util;

import com.zhku.mh.parse.DataParse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpUtils;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-09 13:57
 */
public class URLFecter {
    public static String URLParser(HttpClient httpClient,String url) throws Exception{
        String content = null;
        HttpResponse response = HTTPUtils.getRawHTML(httpClient, url);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200){
            String html = EntityUtils.toString(response.getEntity(),"UTF-8");
            content = DataParse.getData(html);
            EntityUtils.consume(response.getEntity());
        }else {
            EntityUtils.consume(response.getEntity());
        }
        return content;
    }
}
