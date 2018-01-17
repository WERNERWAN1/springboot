/**
 *@Description: TODO 
 *@Copyright(c):All rights reserved.
 *@Package:  entity
 *@Author： werner 2018-01-16 10:37
 *@Version: 1.0  
 */
package com.werner.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *@Description: TODO 
 *@Copyright(c):All rights reserved.
 *@Author： werner 2018-01-16 10:37
 *@Version: 1.0  
 */
@Data
public class Banner implements Serializable {
    private static final long serialVersionUID = -8392641335850163492L;
    /**id */
    private Integer id;

    /**banner标题 */
    private String title;

    /**banner类型，0 H5，1富文本 */
    private Byte type;

    /**素材ID */
    private Integer materialId;

    /**链接 */
    private String link;

    /**图片链接 */
    private String logo;

    /**分享logo */
    private String shareLogo;

    /**备注 */
    private String remark;

    /**排序 */
    private Byte sort;

    /**上架时间 */
    private Date startTime;

    /**下架时间 */
    private Date endTime;

    /**创建时间 */
    private Date createTime;


}