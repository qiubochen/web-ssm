package com.heitian.ssm.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.json.JsonObject;

public interface ShoppingCartService {
    public JSONArray getShoppingCartByUserId(int userId);
    public int addShoppingCart(int bookId, int userId, int bookAccount);
}
