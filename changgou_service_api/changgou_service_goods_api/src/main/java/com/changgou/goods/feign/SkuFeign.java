package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author JinLu
 */
@FeignClient(name = "goods")
public interface SkuFeign {

    /**
     * 通过Spu ID查找Sku列表
     *
     * @param spuId
     * @return
     */
    @GetMapping("/sku/spu/{spuId}")
    public List<Sku> findSkuListBySpuId(@PathVariable("spuId") String spuId);

    /**
     * 根据id查询sku信息 * @param id
     *
     * @return
     */
    @GetMapping("/sku/{id}")
    public Result<Sku> findById(@PathVariable("id") String id);
}
