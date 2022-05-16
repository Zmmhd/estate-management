package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.entity.Letter;
import com.heima.estatemanagement.entity.Letter;
import com.heima.estatemanagement.mapper.LetterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/16/19:33
 * @Description:
 */
@Service
public class LetterService implements BaseService<Letter>{

    @Autowired
    LetterMapper letterMapper;

    @Override
    public List<Letter> findAll() {
        return letterMapper.selectAll();
    }

    @Override
    public Page<Letter> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Letter.class);
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 2;
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();//创建查询条件
            //时间区间
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                criteria.andGreaterThanOrEqualTo("createTime", searchMap.get("startTime"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                criteria.andLessThanOrEqualTo("createTime", searchMap.get("endTime"));
                criteria.andLessThanOrEqualTo("createTime", searchMap.get("endTime"));
            }
            //名称模糊搜索
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");
            }
            if ((Integer) searchMap.get("pageNum") != null) {
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if ((Integer) searchMap.get("pageSize") != null) {
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        //使用PageHelper插件完成分页
        Page<Letter> letters = (Page<Letter>) letterMapper.selectByExample(example);
        return letters;
    }

    @Override
    public Boolean add(Letter letter) {
        int row = letterMapper.insert(letter);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public Letter findById(Integer id) {
        return letterMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Letter letter) {
        int row = letterMapper.updateByPrimaryKeySelective(letter);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            letterMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
