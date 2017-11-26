package com.heitian.ssm.dao;

import com.heitian.ssm.model.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDao {
    List<Book> selectAllBook();
    Book selectBookById(@Param("id") int id);
    List<Book>selectBookByPublishingHouse(@Param("strOfPublishingHouse") String strOfPublishingHouse);
    List<Book>selectBookByBookName(@Param("strOfBookName") String strOfBookName);
}
