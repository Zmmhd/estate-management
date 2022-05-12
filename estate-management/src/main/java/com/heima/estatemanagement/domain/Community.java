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
@Table(name="tb_community")
public class Community implements Serializable {

    @Id
    private Integer id;

    private String code;
    private String name;
    private String address;
    private Double area;
    private Integer totalBuildings;
    private Integer totalHouseholds;
    private Integer greeningRate;
    private String thumbnail;
    private String developer;
    private String estateCompany;
    private Date createTime;
    private Date updateTime;
    private String status;

}
