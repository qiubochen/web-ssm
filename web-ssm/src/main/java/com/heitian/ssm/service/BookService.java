package com.heitian.ssm.service;

import com.alibaba.fastjson.JSONArray;
import com.heitian.ssm.model.Book;

import java.util.List;

public interface BookService {
    List<Book>getAllBook();
    public JSONArray searchBookByPublishingHouseOrBookName(String strOfNameOrPublishingHouse);
}
