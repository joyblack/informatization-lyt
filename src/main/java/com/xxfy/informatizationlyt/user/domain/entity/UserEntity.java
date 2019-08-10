package com.xxfy.informatizationlyt.user.domain.entity;

import com.xxfy.informatizationlyt.common.domain.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
@Entity(name = "all_user")
public class UserEntity extends BaseEntity {

    /**
     * 登陆名
     */
    @NotEmpty(message = "登录名不能为空")
    @Column(nullable = false)
    private String loginName;

    /**
     * 真实姓名
     */
    private String userName;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Column(nullable = false)
    private String password;


    @Transient
    private String affirmPassword;

    /**
     * 电话号码
     */
    @NotEmpty(message = "电话号码不能为空")
    @Column(nullable = false)
    private String phone;

    /**
     * 身份证号码
     */
    @NotEmpty(message = "身份证号码不能为空")
    @Column(nullable = false)
    private String idNumber;



}
