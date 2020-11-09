package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;
import com.example.demo.request.CheckUserReq;

/**
 * @Author Administrator
 * @Date 2020/11/9
 */
public interface UserService extends IService<User> {

    /**
     * 检查用户
     */
    String checkUser(CheckUserReq checkUserReq);

    /**
     * 新增用户
     */
    String addUser(CheckUserReq checkUserReq);

    /**
     * 刷新redis
     */
    void addToRedis();

}
