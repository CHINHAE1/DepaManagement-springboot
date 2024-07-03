package org.example.depamanagement.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.depamanagement.mapper.EmpMapper;
import org.example.depamanagement.pojo.Emp;
import org.example.depamanagement.pojo.PageBean;
import org.example.depamanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/3 10:05
 * @version: 1.0
 */
// 员工业务实现类
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
  @Autowired
  private EmpMapper empMapper;

  @Override
  public void save(Emp emp) {
    //补全数据
    emp.setCreateTime(LocalDateTime.now());
    emp.setUpdateTime(LocalDateTime.now());
    //调用添加方法
    empMapper.insert(emp);
  }

  @Override
  public void delete(List<Integer> ids) {
    empMapper.delete(ids);
  }

  /*@Override
  public PageBean page(Integer page, Integer pageSize) {
      //1、获取总记录数
      Long count = empMapper.count();

      //2、获取分页查询结果列表
      Integer start = (page - 1) * pageSize; //计算起始索引 , 公式: (页码-1)*页大小
      List<Emp> empList = empMapper.list(start, pageSize);

      //3、封装PageBean对象
      PageBean pageBean = new PageBean(count , empList);
      return pageBean;
  }*/

  /*public PageBean page(Integer page, Integer pageSize) {
    // 使用PageHelper分页插件
    PageHelper.startPage(page, pageSize);
    // 查询全部员工信息
    List<Emp> empList = empMapper.list();
    // 取分页信息
    PageInfo<Emp> pageInfo = new PageInfo<>(empList);
    // 封装PageBean对象
    PageBean pageBean = new PageBean(pageInfo.getTotal(), pageInfo.getList());
    return pageBean;
  }*/

  @Override
  public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
    //设置分页参数
    PageHelper.startPage(page, pageSize);
    //执行条件分页查询
    List<Emp> empList = empMapper.list(name, gender, begin, end);
    //获取查询结果
    Page<Emp> p = (Page<Emp>) empList;
    //封装PageBean
    PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
    return pageBean;
  }
}
