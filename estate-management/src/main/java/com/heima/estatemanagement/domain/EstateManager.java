package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/15:43
 * @Description:
 */
@Data
@Table(name = "tb_estate_manager")
public class EstateManager {
    @Id
    Integer id;
    Integer communityId;
    String communityName;
    String code;
    String name;
    Timestamp createTime;
    Timestamp updateTime;
    Integer money;
}
