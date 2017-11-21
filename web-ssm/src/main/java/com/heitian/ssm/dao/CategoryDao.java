package com.heitian.ssm.dao;

import com.heitian.ssm.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryDao {
    List<Category>selectAllCategory();
    List<Integer>selectBookIdByName(@Param("name")String name);
}
