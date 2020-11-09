package com.example.demo.controller;

import com.example.demo.request.CheckUserReq;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Administrator
 * @Date 2020/11/9
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/checkUser")
    public ResultApi checkUser(@RequestBody CheckUserReq req) {

        String userID = userService.checkUser(req);

        if (StringUtils.isEmpty(userID)) {
            userID = userService.addUser(req);
        }

        return ResultApi.success().put("userID", userID);
    }

    @GetMapping("/addToRedis")
    public ResultApi addToRedis() {
        userService.addToRedis();
        return ResultApi.success();
    }


}
