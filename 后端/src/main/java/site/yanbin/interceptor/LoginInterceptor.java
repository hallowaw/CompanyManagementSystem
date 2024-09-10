package site.yanbin.interceptor;

import com.alibaba.fastjson.JSONObject;
import site.yanbin.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、定义拦截器：实现拦截器接口 HandlerInterceptor 从写方法preHandle处理拦截。
 * 2、加上注解 @Component 把拦截器对象交给spring 容器管理。
 * 3、注册拦截器给spring容器，让拦截器对象生效。
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JWTUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器拦截请求：{}", request.getRequestURI());
        // 校验这个请求的token
        // 1、获取当前请求对象中的请求头：token 值，认证JWT令牌是否有效。
        String token = request.getHeader("token");
        // 2、直接调用工具类的方法，校验token是否合法
        try {
            jwtUtils.parseJWT(token);
            log.info("拦截器放行请求：{}", request.getRequestURI());
            // 放行
            return true;
        } catch (Exception e) {
            // jwt令牌非法，拦截回去，返回错误信息
            JSONObject result = new JSONObject();
            result.put("code", 0);
            result.put("msg", "NOT_LOGIN");
            result.put("data", null);
            // 转换成json字符串形式
            response.getWriter().write(result.toJSONString());
            log.info("拦截器拦截请求-不允许放行，token失效：{}", request.getRequestURI());
            return false;
        }
    }
}
