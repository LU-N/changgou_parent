package com.changgou.pay.service.impl;

import com.changgou.pay.service.WXPayService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JinLu
 */
@Service
public class WXPayServiceImpl implements WXPayService {


    private WXPay wxPay;

    @Value("${wxpay.notify_url}")
    private String notify_url;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 统一下单接口调用
     *
     * @param orderId
     * @param money
     * @return
     */
    @Override
    public Map nativePay(String orderId, Integer money) {
        try {
            //1. 封装请求参数
            Map<String, String> map = new HashMap<>(16);
            map.put("appid", "wx8397f8696b538317");
            map.put("mch_id", "1473426802");
            map.put("nonce_str", WXPayUtil.generateNonceStr());
            map.put("body", "畅购");
            map.put("out_trade_no", orderId);

            BigDecimal payMoney = new BigDecimal("0.01");
            BigDecimal fen = payMoney.multiply(new BigDecimal("100"));
            fen = fen.setScale(0, BigDecimal.ROUND_UP);
            map.put("total_fee", String.valueOf(fen));

            map.put("spbill_create_ip", "127.0.0.1");
            map.put("notify_url", notify_url);
            map.put("trade_type", "NATIVE");

            String xml = WXPayUtil.generateSignedXml(map, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb");
            System.out.println(xml);

            MultiValueMap headers = new LinkedMultiValueMap();
            headers.set("content-type", "text/xml;charset=utf-8");
            HttpEntity httpEntity = new HttpEntity(xml, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.mch.weixin.qq.com/pay/unifiedorder", HttpMethod.POST, httpEntity, String.class);
            String body = responseEntity.getBody();
            Map<String, String> result = WXPayUtil.xmlToMap(body);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map queryOrder(String orderId) {
        try {
            Map<String, String> map = new HashMap(16);
            map.put("appid", "wx8397f8696b538317");
            map.put("mch_id", "1473426802");
            map.put("out_trade_no", orderId);
            map.put("nonce_str", WXPayUtil.generateNonceStr());
            String xml = WXPayUtil.generateSignedXml(map, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb");

            MultiValueMap headers = new LinkedMultiValueMap();

            headers.set("content-type", "text/xml;charset=utf-8");
            HttpEntity httpEntity = new HttpEntity(xml, headers);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://api.mch.weixin.qq.com/pay/orderquery", httpEntity, String.class);
            String body = responseEntity.getBody();
            Map<String, String> result = WXPayUtil.xmlToMap(body);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
