package com.changgou.goods.dao;

import com.changgou.goods.pojo.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author JinLu
 */
public interface SpecMapper extends Mapper<Spec> {

    /**
     * 根据商品分类名称查询规格
     *
     * @param categoryName
     * @return
     */
    @Select("select name, options from tb_spec where template_id in (select template_id from tb_category where tb_category.name = '手机')order by seq")
    public List<Map> findListByCategoryName(@Param("categoryName") String categoryName);
}
