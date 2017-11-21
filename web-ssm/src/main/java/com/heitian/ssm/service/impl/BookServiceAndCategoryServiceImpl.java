package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.BookDao;
import com.heitian.ssm.dao.CategoryDao;
import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.Book;
import com.heitian.ssm.model.Category;
import com.heitian.ssm.service.BookService;
import com.heitian.ssm.service.CategoryService;
import com.heitian.ssm.utils.BookComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.alibaba.fastjson.*;

import javax.annotation.Resource;

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
        Set<Category>setOfCategory=new TreeSet<Category>();
        JSONObject jsonObject=new JSONObject();

        listOfCategory=categoryDao.selectAllCategory();

        Iterator<Category>iteratorOfListOfCategory=listOfCategory.iterator();
        Iterator<Category>iteratorOfSetOfCategory=setOfCategory.iterator();

        while(iteratorOfListOfCategory.hasNext()){
            setOfCategory.add(iteratorOfListOfCategory.next());
        }
        while (iteratorOfSetOfCategory.hasNext()){
            List<Integer>list=new ArrayList<Integer>();
            List<Book>listToCompareByClickCount=new ArrayList<Book>();

            list=categoryDao.selectBookIdByName(iteratorOfSetOfCategory.next().getName());
            Iterator iterator=list.iterator();

            while(iterator.hasNext()){

               listToCompareByClickCount=bookDao.selectBookById((Integer) iterator.next());

            }
            Collections.sort(listToCompareByClickCount,new BookComparator());
            jsonObject.put(iteratorOfSetOfCategory.next().getName(),listToCompareByClickCount);
        }
        return jsonObject;
    }

}
