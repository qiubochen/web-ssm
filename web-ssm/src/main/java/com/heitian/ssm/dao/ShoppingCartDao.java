package com.heitian.ssm.dao;

import com.heitian.ssm.model.ShoppingCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShoppingCartDao {
    List<ShoppingCart>selectShoppingCartByUserId(@Param("userId") int userId);
    void insertShoppingCart(@Param("userId")int userId,@Param("bookId") int bookId,@Param("bookAccount") int bookAccount,@Param("cost") int cost);
}
