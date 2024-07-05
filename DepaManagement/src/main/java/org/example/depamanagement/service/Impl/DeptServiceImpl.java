package org.example.depamanagement.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.depamanagement.mapper.DeptMapper;
import org.example.depamanagement.mapper.EmpMapper;
import org.example.depamanagement.pojo.Dept;
import org.example.depamanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/3 09:57
 * @version: 1.0
 */

// 部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;


    @Override
    public void add(Dept dept) {
        //补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用持久层增加功能
        deptMapper.inser(dept);
    }

    //根据部门id，删除部门信息及部门下的所有员工
    @Override
    public void delete(Integer id) {
        //根据部门id删除部门信息
        deptMapper.deleteById(id);

        //模拟:异常发生
        int i = 1/0;

        //删除部门下的所有员工信息
        empMapper.deleteByDeptId(id);
    }

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }
}
