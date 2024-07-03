package org.example.depamanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.depamanagement.pojo.Emp;
import org.example.depamanagement.pojo.PageBean;
import org.example.depamanagement.pojo.Result;
import org.example.depamanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/3 10:18
 * @version: 1.0
 */

// 员工管理控制器
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
  @Autowired
  private EmpService empService;

  //新增
  @PostMapping
  public Result save(@RequestBody Emp emp){
    //记录日志
    log.info("新增员工, emp:{}",emp);
    //调用业务层新增功能
    empService.save(emp);
    //响应
    return Result.success();
  }

  //批量删除
  @DeleteMapping("/{ids}")
  public Result delete(@PathVariable List<Integer> ids){
    empService.delete(ids);
    return Result.success();
  }

 /* // 条件分页查询
  @GetMapping
  public Result page(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    // 记录日志
    log.info("分页查询，参数：{},{}", page, pageSize);
    // 调用业务层分页查询功能
    PageBean pageBean = empService.page(page, pageSize);
    // 响应
    return Result.success(pageBean);
  }*/

  //条件分页查询
  @GetMapping
  public Result page(@RequestParam(defaultValue = "1") Integer page,
                     @RequestParam(defaultValue = "10") Integer pageSize,
                     String name, Short gender,
                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
    //记录日志
    log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize,name, gender, begin, end);
    //调用业务层分页查询功能
    PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
    //响应
    return Result.success(pageBean);
  }
}
