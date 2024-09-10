package site.yanbin.service;

import site.yanbin.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    int delete(Integer id);

    int save(Dept dept);

    Dept getById(Integer id);

    int update(Dept dept);
}
