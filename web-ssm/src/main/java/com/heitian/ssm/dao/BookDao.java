package com.heitian.ssm.dao;

import com.heitian.ssm.model.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDao {
    List<Book> selectAllBook();
    List<Book> selectBookById(@Param("id") int id);
}
