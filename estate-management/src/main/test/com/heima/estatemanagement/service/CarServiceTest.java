package com.heima.estatemanagement.service;

import com.github.pagehelper.PageInfo;
import com.heima.estatemanagement.EstateManagementApplication;
import com.heima.estatemanagement.entity.Vo.CarVo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstateManagementApplication.class)
public class CarServiceTest extends TestCase {

    @Autowired
    CarService carService;

    @Test
    public void testSearch() {
        PageInfo<CarVo> search = carService.search(null);
        List<CarVo> list = search.getList();
        list.forEach(System.out::println);
    }
}