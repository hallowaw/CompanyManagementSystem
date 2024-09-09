package site.yanbin.controller;

import site.yanbin.entity.Dept;
import site.yanbin.response.Result;
import site.yanbin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/depts") // 统一定位符！
public class DeptController {
    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts" , method = RequestMethod.GET) // get
    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    // 写一个接口，接收restful风格的地址 请求方式是接收delete /depts/2 删除id为2的数据
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        int count = deptService.delete(id);
        return Result.status(count);
    }

//    @RequestMapping(value = "/depts" , method = RequestMethod.POST) // post
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        int count = deptService.save(dept);
        return Result.status(count);
    }

    // 修改步骤1：提供一个根据id查询部门响应给前端的接口。
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    // 修改步骤2：提供一个接口，是put请求的方式，接收前端送过来的部门数据进行修改，
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        int count = deptService.update(dept);
        return Result.status(count);
    }
}
