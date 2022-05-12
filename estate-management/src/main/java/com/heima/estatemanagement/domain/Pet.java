package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/14:36
 * @Description:
 */
@Data
@Table(name = "tb_pet")
public class Pet {
    @Id
    Integer id;
    String communityName;
    Integer communityId;
    String picture;
    String code;
    String name;
    Timestamp createTime;
    Timestamp updateTime;
}
