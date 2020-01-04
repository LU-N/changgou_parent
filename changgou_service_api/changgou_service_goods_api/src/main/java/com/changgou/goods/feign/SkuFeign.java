package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 删减库存
     *
     * @param username
     * @return
     */
    @PostMapping("/sku/decr/count")
    public Result decrCount(@RequestParam("username") String username);

    @RequestMapping("/resumeStockNum")
    public Result resumeStockNum(@RequestParam("skuId") String skuId,@RequestParam("num")Integer num);
}
