package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/14:21
 * @Description:
 */
@Data
@Table(name = "tb_letter")
public class Letter {
    @Id
    Integer id;
    Integer communityId;
    String communityName;
    Integer ownerId;
    String ownerName;
    char origin;
    String title;
    String content;
    Timestamp createTime;
    Timestamp updateTime;
    char status;

}
