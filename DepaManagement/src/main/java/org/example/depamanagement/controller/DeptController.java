package org.example.depamanagement.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.depamanagement.pojo.Dept;
import org.example.depamanagement.pojo.Result;
import org.example.depamanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/3 10:17
 * @version: 1.0
 */

// 部门管理控制器
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
  @Autowired private DeptService deptService;

  @PostMapping
  public Result add(@RequestBody Dept dept){
    //记录日志
    log.info("新增部门：{}",dept);
    //调用service层添加功能
    deptService.add(dept);
    //响应
    return Result.success();
  }

  @DeleteMapping("/{id}")
  public Result delete(@PathVariable Integer id) {
    //日志记录
    log.info("根据id删除部门");
    //调用service层功能
    deptService.delete(id);
    //响应
    return Result.success();
  }

  // @RequestMapping(value = "/depts" , method = RequestMethod.GET)
  @GetMapping
  public Result list() {
    log.info("查询所有部门数据");
    List<Dept> deptList = deptService.list();
    return Result.success(deptList);
  }
}
