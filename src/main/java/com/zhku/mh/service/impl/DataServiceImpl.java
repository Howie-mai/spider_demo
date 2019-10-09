package com.zhku.mh.service.impl;

import com.zhku.mh.service.DataService;
import com.zhku.mh.util.HTTPUtils;
import com.zhku.mh.util.URLFecter;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-09 16:01
 */
@Service
public class DataServiceImpl implements DataService {
    HttpClient client = HttpClients.createDefault();

    @Override
    public String getData(String strUrl) {
        String content = null;
        try {
            URL url = new URL(strUrl);
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            content = URLFecter.URLParser(client, uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
