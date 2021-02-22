package com.example.demo.po;

import lombok.Data;

/**
 * @Author: Eagle
 * @Date 2021/1/17 8:14 上午
 **/
@Data
public class ExcelGuildUser {
  private String orderId;
  private String orderTime;
  private String userId;
  private String guildName;
  private String mcId;
  private String scId;
  private String platformId;
  private String gameId;
  private String gameName;
  private String zoneId;
  private String zoneName;
  private String roleId;
  private String roleName;
  private double orderMoney;
  private double realMoney;

  //存在Mongo UserFields
  private String realName;
  private String idCard;
  private String phoneNumber;
}
