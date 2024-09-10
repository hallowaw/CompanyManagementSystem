package site.yanbin.service.impl;

import site.yanbin.entity.Dept;
import site.yanbin.repository.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanbin.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    @Override
    public int delete(Integer id) {
        return deptMapper.delete(id);
    }

    @Override
    public int save(Dept dept) {
        try {
            return deptMapper.save(dept);
        } catch (Exception e) {
            throw new RuntimeException("您添加的部门信息已经存在，请重新输入！");
        }
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public int update(Dept dept) {
        // 修改时间，真的需要更新一下了。
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.update(dept);
    }
}
