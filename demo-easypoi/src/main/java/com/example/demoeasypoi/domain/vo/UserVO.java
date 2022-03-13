package com.example.demoeasypoi.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 兰建青
 * @title: UserController
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2021/12/16 12:03
 */
@Data
@ToString
public class UserVO implements Serializable {
    @Excel(name = "ID", width = 10)
    private Long id;
    @Excel(name = "用户名", width = 20, needMerge = true)
    private String username;
    private String password;
    @Excel(name = "昵称", width = 20, needMerge = true)
    private String nickname;
    @Excel(name = "出生日期", width = 20, format = "yyyy-MM-dd")
    private Date birthday;
    @Excel(name = "手机号", width = 20, needMerge = true, desensitizationRule = "3_4")
    private String phone;
    private String icon;
    @Excel(name = "性别", width = 10, replace = {"男_0", "女_1"})
    private Integer gender;
}