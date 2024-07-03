package org.example.depamanagement.service;

import org.example.depamanagement.pojo.Dept;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/3 09:56
 * @version: 1.0
 */

// 部门业务规则接口
public interface DeptService {

    /**
     * 新增部门
     * @param dept  部门对象
     */
    void add(Dept dept);

    /**
     * 根据id删除部门
     * @param id    部门id
     */
    void delete(Integer id);


    /**
     * 查询所有的部门数据
     * @return   存储Dept对象的集合
     */
    List<Dept> list();
}
