/**
 * @Description: TODO
 * @Copyright(c):All rights reserved.
 * @Package: mapper
 * @Author： werner 2018-01-15 17:01
 * @Version: 1.0
 */
package com.werner.mapper;


import com.werner.common.mapper.BaseMapper;
import com.werner.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User selectUserByLogin(User user);
}