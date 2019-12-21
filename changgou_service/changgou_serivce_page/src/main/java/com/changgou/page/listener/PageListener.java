package com.changgou.page.listener;

import com.changgou.page.config.RabbitMQConfig;
import com.changgou.page.service.PageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JinLu
 * @date 2019/12/20 19:23
 */
@Component
public class PageListener {
    @Autowired
    private PageService pageService;

    @RabbitListener(queues = RabbitMQConfig.PAGE_CREATE_QUEUE)
    public void receiveMessage(String spuId) {
        System.out.println("接收到的spuId：" + spuId);
        //生成静态化页面
        pageService.generateHtml(spuId);
    }
}
