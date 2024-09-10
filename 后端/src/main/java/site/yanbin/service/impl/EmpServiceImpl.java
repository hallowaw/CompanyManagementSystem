package site.yanbin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import site.yanbin.dto.PageBean;
import site.yanbin.entity.Emp;
import site.yanbin.repository.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanbin.service.EmpService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    // 原始做法实现分页
    @Override
    public PageBean getEmpsByPage(Integer page, Integer pageSize) {
        // 1、查询当前总共的数据有多少条。
        long total = empMapper.getTotal();

        // 2、查询当前这一页的员工信息，封装成集合返回
        int startIndex = (page - 1) * pageSize;
        List<Emp> emps = empMapper.getEmpsByPage(startIndex, pageSize);

        // 3、把这一页的数据和总数量条数封装成一个PageBean对象返回出去。
        return new PageBean(total, emps);
    }


    // pageHelper分页插件实现分页
    public PageBean  getEmpsByPage2(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        // 1、把当前页码 和每页要展示的数量交给PagerHelper分页插件。
        PageHelper.startPage(page, pageSize);

        // 2、查询员工信息
        // 当前这个方法并不是直接去执行的！
        // emps其实接收到的一个底层返回的一个Page对象（总数，当前页的员工集合）
        List<Emp> results = empMapper.getEmps(name, gender, begin, end);

        // 3、把分页插件查询出来的数据转换成真正的Page对象，返回。
        Page<Emp> pageInfo = (Page<Emp>) results;
        Long total = pageInfo.getTotal(); // 总条数
        List<Emp> emps = pageInfo.getResult(); // 当前页的员工集合

        return new PageBean(total, emps);
    }

    @Override
    public void save(Emp emp) {
        // 注入基础字段的数据：创建日期，修改日期。
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp getLoginEmpByEmp(Emp emp) {
        Emp e = empMapper.getLoginEmpByEmp(emp);
        return e;
    }
}
