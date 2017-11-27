package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.dao.ShoppingCartDao;
import com.heitian.ssm.model.ShoppingCart;
import com.heitian.ssm.service.ShoppingCartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.json.JsonArray;
import javax.json.JsonObject;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;
    @RequestMapping(value = "/showshoppingcart",method = RequestMethod.GET)
    public @ResponseBody
    JSONArray showShoppingCart(@RequestParam(value = "userId") int userId ){
        return shoppingCartService.getShoppingCartByUserId(userId);
    }
    @RequestMapping(value = "/addshoppingcart",method = RequestMethod.POST)
     public   @ResponseBody JSONObject addShoppingCart(@RequestBody ShoppingCart shoppingCart){
        int status= shoppingCartService.addShoppingCart(shoppingCart.getBookId(),shoppingCart.getUserId(),shoppingCart.getBookAccount());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",status);
        return jsonObject;
    }
}
