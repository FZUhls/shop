package com.henry.shop.common.base.model.dataobj.usr;

import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.MemberStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henry1
 * 会员表
 */
@Data
@TableName("usr_member")
public class Member implements Serializable {
    private Long id;
    /**
     * 顾客id
     */
    private Long customerId;
    /**
     * 会员等级
     */
    private Long memLevelId;
    /**
     * 会员状态
     */
    private MemberStatus status;
    /**
     * 会员积分
     */
    private Integer memScore;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
