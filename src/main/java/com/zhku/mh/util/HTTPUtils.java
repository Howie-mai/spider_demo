package com.zhku.mh.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-09 14:04
 */
public class HTTPUtils {
     public static HttpResponse getRawHTML(HttpClient client, String personalUrl){
          HttpGet getMethod = new HttpGet(personalUrl);
          HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
          try {
               response = client.execute(getMethod);
          }catch (IOException e){
               e.printStackTrace();
          }
          return response;
     }
}
