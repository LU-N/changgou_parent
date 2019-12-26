package com.changgou.user.feign;

import com.changgou.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author JinLu
 * @date 2019/12/24 11:26
 */
@FeignClient(name = "user")
public interface UserFeign {
    /**
     * 查找用户信息
     *
     * @param username
     * @return
     */
    @GetMapping("/user/load/{username}")
    public User findUserInfo(@PathVariable("username") String username);
}
