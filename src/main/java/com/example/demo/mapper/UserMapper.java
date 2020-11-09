package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/11/9
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> findAllUser();

}
