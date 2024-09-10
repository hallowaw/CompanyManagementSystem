package site.yanbin.controller;

import site.yanbin.entity.Emp;
import site.yanbin.response.Result;
import site.yanbin.service.EmpService;
import site.yanbin.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) throws Exception {
        Emp loginEmp = empService.getLoginEmpByEmp(emp);
        if(loginEmp != null){
            // 登录成功了：生成JWT令牌给前端网页。
            Map<String, Object> claims = new HashMap();
            claims.put("id", loginEmp.getId());
            claims.put("username", loginEmp.getUsername());
            claims.put("name", loginEmp.getName());

            String jwtToken = jwtUtils.createJWT(claims);
            // 响应给前端浏览器
            return Result.success(jwtToken);
        }
        // 登录失败！
        return  Result.error("NOT_LOGIN");
    }
}
