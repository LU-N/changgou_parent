package com.changgou.order.feign;

import com.changgou.entity.Result;
import com.changgou.order.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author JinLu
 */
@FeignClient(name = "order")
public interface OrderFeign {

    /**
     * 添加
     *
     * @param order
     * @return
     */
    @PostMapping("/order")
    public Result add(@RequestBody Order order);
}
