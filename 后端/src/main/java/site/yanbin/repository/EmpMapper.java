package site.yanbin.repository;

import site.yanbin.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp")
    int getTotal();

    // 这一页第一条数据的计算公式：(当前页码-1) * 每页显示的条数
    @Select("select * from emp limit #{startIndex},#{pageSize}")
    List<Emp> getEmpsByPage(@Param("startIndex") Integer startIndex,
                            @Param("pageSize") Integer pageSize);

    // 条件查询
    List<Emp> getEmps(@Param("name") String name,
                      @Param("gender") Integer gender,
                      @Param("begin") LocalDate begin,
                      @Param("end")LocalDate end);

    @Insert("insert into emp (username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{password}, #{name}, #{gender}, #{image} , #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void save(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    @Update("update emp set username = #{username},  name = #{name}, gender = #{gender}, image = #{image}, " +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getLoginEmpByEmp(Emp emp);
}
