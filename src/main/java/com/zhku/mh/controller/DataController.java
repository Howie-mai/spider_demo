package com.zhku.mh.controller;

import com.zhku.mh.entities.Book;
import com.zhku.mh.entities.DataEntity;
import com.zhku.mh.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName:
 * @description
 * @author: mh
 * @create: 2019-10-09 16:08
 */
@Controller
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping("/getData")
    @ResponseBody
    public DataEntity getData(DataEntity entity){

        String data = dataService.getData(entity.getStrURL());

//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("dataIndex");
//        mav.addObject("data",data);
//        return mav;
        entity.setSeason(data);
        return entity;
    }

    @RequestMapping("/getBook")
    public ModelAndView getBook(Book book){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("dataIndex");
        mav.addObject("data",book.getName());
        return mav;
    }
}
