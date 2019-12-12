package com.changgou.system.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @author JinLu
 * @date 2019/12/9 13:56
 */
@Component
public class IpFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取客户端的访问ip
        ServerHttpRequest request = exchange.getRequest();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        System.out.println("ip: " + remoteAddress.getHostName());

        return chain.filter(exchange);
    }

    /**
     * 过滤器的执行优先级,返回值越小,执行优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}

