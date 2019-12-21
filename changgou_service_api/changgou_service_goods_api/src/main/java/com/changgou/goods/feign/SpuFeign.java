package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author JinLu
 * @date 2019/12/20 14:27
 */
@FeignClient(name = "goods")
public interface SpuFeign {
    /**
     * 根据id查询Spu
     *
     * @param id
     * @return
     */
    @GetMapping("/spu/findSpuById/{id}")
    public Result<Spu> findSpuById(@PathVariable("id") String id);
}
