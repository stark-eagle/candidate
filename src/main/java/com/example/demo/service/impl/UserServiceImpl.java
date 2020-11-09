package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.request.CheckUserReq;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Administrator
 * @Date 2020/11/9
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;


    public void addToRedis() {
        List<User> userList = userMapper.findAllUser();
        for (User user : userList) {
            String userID = user.getUserID();
            List<Integer> list = new LinkedList<>();
            list.add(user.getId1());
            list.add(user.getId2());
            redisUtils.add(list.toString(), userID);
        }
    }


    public String checkUser(CheckUserReq req) {
        List<Integer> list = new LinkedList<>();
        Integer id1 = req.getId1();
        Integer id2 = req.getId2();
        list.add(id1);
        list.add(id2);
        String key=list.toString();
        boolean temp = redisUtils.exists(key);
        Object object= redisUtils.get(key);
        System.out.println(object);
        if (temp) {
            return (String) redisUtils.get(key);
        }
        return null;
    }


    public String addUser(CheckUserReq req) {
        String userID = UUID.randomUUID().toString();
        User user = new User();
        user.setId1(req.getId1());
        user.setId2(req.getId2());
        user.setUserID(userID);
        userMapper.insert(user);
        List<Integer> list = new LinkedList<>();
        list.add(user.getId1());
        list.add(user.getId2());
        redisUtils.set(list.toString(), userID);
        return userID;
    }

}
