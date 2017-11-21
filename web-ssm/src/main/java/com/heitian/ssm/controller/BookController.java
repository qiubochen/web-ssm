package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.dao.CategoryDao;
import com.heitian.ssm.service.BookService;
import com.heitian.ssm.service.CategoryService;
import com.heitian.ssm.service.impl.BookServiceAndCategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;
    @Resource
    private CategoryService categoryService;
    @RequestMapping("/showbook")
    public @ResponseBody
    JSONObject show(){
       BookServiceAndCategoryServiceImpl bookServiceAndCategoryService=new BookServiceAndCategoryServiceImpl();
       return bookServiceAndCategoryService.sortAllBookAndCategory();
    }

}
