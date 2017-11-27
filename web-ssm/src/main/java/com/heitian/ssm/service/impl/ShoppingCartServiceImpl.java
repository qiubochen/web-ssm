package com.heitian.ssm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.dao.BookDao;
import com.heitian.ssm.dao.ShoppingCartDao;
import com.heitian.ssm.model.Book;
import com.heitian.ssm.model.ShoppingCart;
import com.heitian.ssm.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    ShoppingCartDao shoppingCartDao;
     @Resource
    BookDao bookDao ;
    public JSONArray getShoppingCartByUserId(int userId) {
        JSONArray jsonArrayOfShoppingCart=new JSONArray();

        List<ShoppingCart> listOfShoppingCartByUserId=new ArrayList();
        listOfShoppingCartByUserId=shoppingCartDao.selectShoppingCartByUserId(userId);
        Iterator iteratorOfListOfShoppingCArt=listOfShoppingCartByUserId.iterator();
        while(iteratorOfListOfShoppingCArt.hasNext()){
            JSONObject jsonObjectOfShoppingCart=new JSONObject();
            ShoppingCart shoppingCart=new ShoppingCart();
            Book book=new Book();
            shoppingCart= (ShoppingCart) iteratorOfListOfShoppingCArt.next();
            book=bookDao.selectBookById(shoppingCart.getBookId());
            jsonObjectOfShoppingCart.put("bookName",book.getName());
            jsonObjectOfShoppingCart.put("cost",shoppingCart.getCost());
            jsonArrayOfShoppingCart.add(jsonObjectOfShoppingCart);
            System.out.println("jsonobject"+jsonObjectOfShoppingCart.toJSONString());
            System.out.println("jsonarray"+jsonArrayOfShoppingCart.toJSONString());
        }
        return jsonArrayOfShoppingCart;
    }

    public int addShoppingCart(int bookId,int userId,int bookAccount) {

        Book book = bookDao.selectBookById((bookId));
        if(book==null)
            return 100003;
        int cost=bookAccount*book.getPrice();
        shoppingCartDao.insertShoppingCart(userId,bookId,bookAccount,cost);
        return 200;
    }
}

