package site.yanbin.service;

import site.yanbin.dto.PageBean;
import site.yanbin.entity.Emp;

import java.time.LocalDate;

public interface EmpService {
    PageBean getEmpsByPage(Integer page, Integer pageSize);

    PageBean getEmpsByPage2(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp getLoginEmpByEmp(Emp emp);
}
