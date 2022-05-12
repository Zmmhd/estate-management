package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/11:03
 * @Description:
 */
@Data
@Table(name = "tb_complaint")
public class Complaint {
    @Id
    Integer id;
    String communityName;
    Integer communityId;
    Integer ownerId;
    String ownerName;
    String description;
    String reason;
    Timestamp createTime;
    Timestamp updateTime;
    char status;

}
