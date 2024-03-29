package com.zhku.mh.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-09 15:32
 */
public class DataParse {
    public static String getData(String html) throws Exception {
        //获取的数据，存放在集合中
        String data = null;
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //获取html标签中的内容
        Elements elements = doc.select("table")
                .select("tbody")
                .select("tr");

        for (Element ele : elements) {
//            String bookID = ele.attr("data-sku");
//            String bookPrice = ele.select("div[class=p-price]").select("strong").select("i").text();
//            String bookName = ele.select("div[class=p-name]").select("em").text();
            data = ele.select("td").html();
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
//            JdModel jdModel = new JdModel();
            //对象的值
//            jdModel.setBookID(bookID);
//            jdModel.setBookName(bookName);
//            jdModel.setBookPrice(bookPrice);
            //将每一个对象的值，保存到List集合中
//            data.add(jdModel);
        }
        //返回数据
        return data;
    }
}
