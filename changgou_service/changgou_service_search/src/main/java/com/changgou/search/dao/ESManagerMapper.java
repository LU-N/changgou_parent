package com.changgou.search.dao;

import com.changgou.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author JinLu
 */
public interface ESManagerMapper extends ElasticsearchRepository<SkuInfo,Long> {
}
