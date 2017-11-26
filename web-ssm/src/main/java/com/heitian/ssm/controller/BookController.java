package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.dao.CategoryDao;
import com.heitian.ssm.service.BookService;
import com.heitian.ssm.service.CategoryService;
import com.heitian.ssm.service.impl.BookServiceAndCategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.json.JsonArray;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private BookServiceAndCategoryServiceImpl bookServiceAndCategoryService;
    @RequestMapping(value = "/showbook",method = RequestMethod.GET)
    public @ResponseBody
    JSONObject show(){
       //BookServiceAndCategoryServiceImpl bookServiceAndCategoryService=new BookServiceAndCategoryServiceImpl();
       return bookServiceAndCategoryService.sortAllBookAndCategory();
    }
    @RequestMapping(value = "/searchbook",method = RequestMethod.GET)
    public @ResponseBody
    JSONArray search(@RequestParam(value = "strOfBookNameOrPublishingHouse") String strOfBookNameOrPublishingHouse){
        System.out.println(strOfBookNameOrPublishingHouse);
        return bookServiceAndCategoryService.searchBookByPublishingHouseOrBookName(strOfBookNameOrPublishingHouse);
    }
}
