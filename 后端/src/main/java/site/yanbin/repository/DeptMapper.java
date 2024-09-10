package site.yanbin.repository;

import site.yanbin.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    int delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, now(), now())")
    int save(Dept dept);

    @Select("select * from dept where id = #{xxxdsdds}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    int update(Dept dept);
}
