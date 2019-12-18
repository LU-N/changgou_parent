package com.changgou.search.service;

import java.util.Map;

/**
 * @author JinLu
 */
public interface SearchService {

    /**
     * 按照查询条件进行数据查询
     *
     * @param searchMap
     * @return
     */
    Map search(Map<String, String> searchMap);
}
