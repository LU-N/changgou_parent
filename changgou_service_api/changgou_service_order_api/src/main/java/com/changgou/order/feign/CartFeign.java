package com.changgou.order.feign;


import com.changgou.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

/**
 * @author JinLu
 */
@FeignClient(name = "order")
public interface CartFeign {

    /**
     * 添加购物车
     *
     * @param skuId
     * @param num
     * @return
     */
    @GetMapping("/cart/addCart")
    public Result addCart(@RequestParam("skuId") String skuId, @RequestParam("num") Integer num);

    /**
     *  查询用户购物车列表
     *
     * @return
     */
    @GetMapping("/cart/list")
    public Map list();
}
