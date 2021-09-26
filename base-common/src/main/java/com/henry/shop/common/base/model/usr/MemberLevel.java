package com.henry.shop.common.base.model.usr;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 会员等级表
 */
@Data
@TableName("usr_member_level")
public class MemberLevel {
    private Long id;
    /**
     * 等级头衔
     */
    private String  levelLabel;
    /**
     * 所需积分
     */
    private Integer needScore;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
