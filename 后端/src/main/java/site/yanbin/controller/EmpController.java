package site.yanbin.controller;

import site.yanbin.dto.PageBean;
import site.yanbin.entity.Emp;
import site.yanbin.response.Result;
import site.yanbin.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    // 分页查询员工的接口：
    @GetMapping
    public Result getEmpsByPage(String name, Integer gender,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
//        PageBean pageBean = empService.getEmpsByPage(page, pageSize); // 原始做法
        PageBean pageBean = empService.getEmpsByPage2(name, gender, begin, end, page, pageSize); // PageHelper分页插件！
        return Result.success(pageBean);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
