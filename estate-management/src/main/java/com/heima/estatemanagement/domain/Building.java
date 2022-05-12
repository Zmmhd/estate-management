package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Author: 朱明名
 * @Date: 2022/5/12
 * @Description:
 */
@Data
@Table(name="tb_building")
public class Building implements Serializable {

    @Id
    private Integer id;
    private String communityName;
    private Integer  communityId;
    private String name;
    private Integer totalHouseholds;
    private String description;
    private Date createTime;
    private Date updateTime;
}
