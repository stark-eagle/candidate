package com.example.demo.entity;

/**
 * @Author Administrator
 * @Date 2020/11/9
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 */
@Data
@TableName(value = "user")
public class User implements Serializable {

    /**
     * id1
     */
    @TableField(value = "id1")
    private Integer id1;

    /**
     * id2
     */
    @TableField(value = "id2")
    private Integer id2;

    /**
     * userID
     */
    @TableField(value = "userID")
    private String userID;


}
