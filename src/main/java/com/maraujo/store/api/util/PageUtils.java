package com.maraujo.store.api.util;

import org.springframework.stereotype.Component;

@Component
public class PageUtils {

    private PageUtils(){}

    public static Integer formatPageSearch(Integer page){
        if(page != 0){
            page = page-1;
        }
        return page;
    }

}
