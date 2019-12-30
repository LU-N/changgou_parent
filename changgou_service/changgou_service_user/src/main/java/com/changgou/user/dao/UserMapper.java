package com.changgou.user.dao;

import com.changgou.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author JinLu
 */
public interface UserMapper extends Mapper<User> {
    /**
     * 更新用户积分
     *
     * @param username
     * @param point
     * @return
     */
    @Update("update tb_user set points=points+#{point} where username=#{username}")
    int updateUserPoint(@Param("username")String username, @Param("point") int point);
}
