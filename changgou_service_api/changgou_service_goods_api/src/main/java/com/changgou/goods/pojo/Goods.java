package com.changgou.goods.pojo;

import java.util.List;

/**
 * @author JinLu
 * @date 2019/12/11 19:56
 */
public class Goods {

    private Spu spu;

    /**sku集合*/
    private List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

}
