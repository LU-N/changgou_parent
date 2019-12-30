package com.changgou.pay.service;

import java.util.Map;

/**
 * @author JinLu
 */
public interface WXPayService {

    /**
     * 支付
     *
     * @param orderId
     * @param money
     * @return
     */
    Map nativePay(String orderId, Integer money);

    /**
     * 基于微信查询订单
     *
     * @param orderId
     * @return
     */
    Map queryOrder(String orderId);
}
