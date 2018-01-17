/**
 *@Description: TODO 
 *@Copyright(c):All rights reserved.
 *@Package:  entity
 *@Author： werner 2018-01-15 17:01
 *@Version: 1.0  
 */
package com.werner.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *@Description: TODO 
 *@Copyright(c):All rights reserved.
 *@Author： werner 2018-01-15 17:01
 *@Version: 1.0  
 */
@Data
public class User implements Serializable {
    /**注册用的手机号码 */
    private String mobile;

    /**平台侧用户id */
    private String dpid;

    /**用户姓名，身份证验证后补齐 */
    private String name;

    /**身份证号，身份证验证后补齐 */
    private String idNumber;

    /**添加时间 */
    private Date addTime;

    /**md5密码 */
    private String passwordMd5;

    /**sha2密码 */
    private String passwordSha2;

    /**1正常 2冻结 3黑名单 */
    private Integer status;

    /**最后登陆时间 */
    private Date lastLogin;

    /** */
    private String lastLoginIp;

    /** */
    private Date loginTokenExpireTime;

    /** */
    private String loginToken;

}