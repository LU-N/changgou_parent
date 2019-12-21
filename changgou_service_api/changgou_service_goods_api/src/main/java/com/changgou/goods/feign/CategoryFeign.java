package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author JinLu
 * @date 2019/12/20 13:51
 */
@FeignClient(name = "goods")
public interface CategoryFeign {
    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public Result<Category> findById(@PathVariable("id") Integer id);
}
