package com.heima.estatemanagement.entity.Vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/15/11:42
 * @Description:
 */
@Data
public class OwnerVo {
    Integer id;
    String communityName;
    String houseName;
    String name;
    String picture;
    String idcard;
    Integer telephone;
    String profession;
    char sex;
    char type;
    String remark;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp birthday;
}
