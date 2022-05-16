package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/10:46
 * @Description:
 */
@Data
@Table(name = "tb_activity")
public class Activity {
    @Id
    Integer id;
    String communityName;
    Integer communityId;
    String title;
    String address;
    String organizer;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp startTime;
    Timestamp endTime;
    char status;
    String phone;
    String content;
}
