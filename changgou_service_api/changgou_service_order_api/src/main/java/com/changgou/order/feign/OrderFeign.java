package com.changgou.order.feign;

import com.changgou.entity.Result;
import com.changgou.order.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 按编号查找
     *
     * @param id
     * @return
     */
    @GetMapping("/order/{id}")
    public Result<Order> findById(@PathVariable("id") String id);
}
