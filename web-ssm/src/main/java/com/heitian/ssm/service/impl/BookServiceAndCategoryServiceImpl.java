package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.BookDao;
import com.heitian.ssm.dao.CategoryDao;
import com.heitian.ssm.model.Book;
import com.heitian.ssm.model.Category;
import com.heitian.ssm.service.BookService;
import com.heitian.ssm.service.CategoryService;
import com.heitian.ssm.utils.BookComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.alibaba.fastjson.*;

@Service
public class BookServiceAndCategoryServiceImpl implements BookService,CategoryService{
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CategoryDao categoryDao;
    public List<Book> getAllBook() {
        return bookDao.selectAllBook();
    }

    public List<Category> getAllCategory() {
        return categoryDao.selectAllCategory();
    }
    public JSONObject sortAllBookAndCategory(){
        List<Category>listOfCategory=new ArrayList<Category>();
        Set<String> setOfCategoryName=new TreeSet<String>();
        JSONObject jsonObject=new JSONObject();

        listOfCategory=categoryDao.selectAllCategory();

        Iterator<Category>iteratorOfListOfCategory=listOfCategory.iterator();


        while(iteratorOfListOfCategory.hasNext()){
            setOfCategoryName.add(iteratorOfListOfCategory.next().getName());
        }
        Iterator<String>iteratorOfSetOfCategoryName = setOfCategoryName.iterator();
        while (iteratorOfSetOfCategoryName.hasNext()){
            List<Integer>list=new ArrayList<Integer>();
            List<Book>listToCompareByClickCount=new ArrayList<Book>();
            String str=(String)iteratorOfSetOfCategoryName.next();
            System.out.println(str);

            list=categoryDao.selectBookIdByName(str);
            Iterator iterator=list.iterator();

            while(iterator.hasNext()){

               listToCompareByClickCount.add((Book) bookDao.selectBookById((Integer) iterator.next()));

            }

            Collections.sort(listToCompareByClickCount,new BookComparator());


            jsonObject.put(str,listToCompareByClickCount);
            System.out.println(jsonObject.toJSONString());
        }
        return jsonObject;
    }
    public JSONArray searchBookByPublishingHouseOrBookName(String strOfNameOrPublishingHouse){
        JSONArray jsonArrayOfBookNameOrPublishingHouse=new JSONArray();
        System.out.println("输入的名字"+strOfNameOrPublishingHouse);

        jsonArrayOfBookNameOrPublishingHouse.add(bookDao.selectBookByBookName(strOfNameOrPublishingHouse));
        jsonArrayOfBookNameOrPublishingHouse.add(bookDao.selectBookByPublishingHouse(strOfNameOrPublishingHouse));

        return jsonArrayOfBookNameOrPublishingHouse;
    }
}
