package com.heitian.ssm.utils;

import com.heitian.ssm.model.Book;

import java.util.Comparator;



public class BookComparator implements Comparator {

    public int compare(Object o1, Object o2) {
       Book b1=(Book)o1;
       Book b2=(Book)o2;
       if(b1.getClickCount()<b2.getClickCount()){
           return 1;
       }else{
           return -1;
       }
    }
}
