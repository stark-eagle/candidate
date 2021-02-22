package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.GuildUser;
import com.example.demo.mapper.GuildUserMapper;
import com.example.demo.po.ExcelGuildUser;
import com.example.demo.request.CheckUserReq;
import com.example.demo.service.UserService;
import com.example.demo.utils.HttpUtil;
import com.example.demo.utils.ResultApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author Administrator
 * @Date 2020/11/9
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;
  @Resource
  private GuildUserMapper guildUserMapper;
  static String url = "https://a.62wy.com/data/export/exportGuildAllUser.do?guildIdsArr=2600&isGroup=1";

  @GetMapping("/checkUser")
  public ResultApi checkUser() {
    String result = HttpUtil.httpsRequest(url, "GET", null);
    JSONObject json = JSONObject.parseObject(result);
    String data = (String) json.get("message");
    JSONArray jsonArray = JSONArray.parseArray(data);
    List<ExcelGuildUser> guildUserList = jsonArray.toJavaList(ExcelGuildUser.class);
    for (ExcelGuildUser excelGuildUser : guildUserList) {
      GuildUser guildUser = new GuildUser();
      BeanUtils.copyProperties(excelGuildUser, guildUser);
      guildUserMapper.insert(guildUser);
    }

    return ResultApi.success();
  }

  @GetMapping("/addToRedis")
  public ResultApi addToRedis() {
    userService.addToRedis();
    return ResultApi.success();
  }


}
