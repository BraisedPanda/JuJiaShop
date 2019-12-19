package com.braisedpanda.mypractices.commons.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-16 11:27
 **/
@Data
@ApiModel(value = "用户实体类")
@Table(name = "user")
public class User {
    @Column(name = "id")
    @Id
    @ApiModelProperty(value="用户id",example = "1")
    private Integer id;
    @ApiModelProperty(value="用户名 username",example = "张三")
    @Column(name = "username")
    private String username;
    @ApiModelProperty(value = "用户密码 password",example = "123456")
    @Column(name = "password")
    private String password;
    @ApiModelProperty(value="邮箱【登录用】email",example = "zhangsan@example.com")
    @Column(name = "email")
    private String email;
    @ApiModelProperty(value="手机号码 phone",example = "183xxxxxxxx")
    @Column(name = "phone")
    private String phone;
    @ApiModelProperty(value="头像url picture",example = "www.xyz.rul")
    @Column(name = "picture")
    private String picture;
    @ApiModelProperty(value="用户角色 role",example = "1")
    @Column(name = "role")
    private Integer role;
    @ApiModelProperty(value="用户状态 status",example = "0")
    @Column(name = "status")
    private Integer status;
    @ApiModelProperty(value="创建时间 create time",example = "2019-12-17 11:13:56")
    @Column(name = "create_time")
    private String createTime;
    @ApiModelProperty(value="token",example = "fghes21")
    @Column(name = "access_token")
    private String accessToken;
}
