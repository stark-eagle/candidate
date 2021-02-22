package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Eagle
 * @Date 2021/1/17 8:10 上午
 **/
@Data
@TableName(value = "guild_user")
public class GuildUser {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  @TableField(value = "userId")
  private String userId;
  @TableField(value = "guildName")
  private String guildName;
  @TableField(value = "mcId")
  private String mcId;
  @TableField(value = "scId")
  private String scId;
  private String gameId;
  @TableField(value = "gameName")
  private String gameName;
  @TableField(value = "zoneName")
  private String zoneName;
  @TableField(value = "roleName")
  private String roleName;
  @TableField(value = "orderMoney")
  private double orderMoney;
  @TableField(value = "realMoney")
  private double realMoney;

  //存在Mongo UserFields
  @TableField(value = "realName")
  private String realName;
  @TableField(value = "idCard")
  private String idCard;
  @TableField(value = "phoneNumber")
  private String phoneNumber;

}
