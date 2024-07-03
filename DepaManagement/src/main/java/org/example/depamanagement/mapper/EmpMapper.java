package org.example.depamanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.depamanagement.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/3 09:56
 * @version: 1.0
 */
@Mapper
public interface EmpMapper {

    //新增员工
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);

    //批量删除
    void delete(@Param("ids") List<Integer> ids);

    //获取总记录数
    @Select("select count(*) from emp")
    public Long count();

    /*//获取当前页的结果列表
    @Select("select * from emp Limit #{start}, #{pageSize}")
    public List<Emp> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);*/

    /*// 获取当前页的结果列表
    @Select("select * from emp")
    public List<Emp> list();*/

    //获取当前页的结果列表
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin,
                          @Param("end") LocalDate end);

}
