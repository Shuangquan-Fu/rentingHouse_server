package com.quan.api.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class RedisCacheInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get or put
        if(StringUtils.equalsIgnoreCase(request.getMethod(), "OPTIONS")){
            return true;
        }
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
// 非get请求，如果不是graphql请求，放行
            if (!StringUtils.equalsIgnoreCase(request.getRequestURI(), "/graphql"))
            {
                return true;
            }
        }
        String data =
                this.redisTemplate.opsForValue().get(createRedisKey(request));
        if (StringUtils.isEmpty(data)) {
// 缓存未命中
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(data);
        return false;
    }
    public static String createRedisKey(HttpServletRequest request) throws
            Exception {
        String paramStr = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        //means this is a get request
        if (parameterMap.isEmpty()) {
            paramStr += IOUtils.toString(request.getInputStream(), "UTF-8");
        } else {
            paramStr += mapper.writeValueAsString(request.getParameterMap());
        }
        String redisKey = "WEB_DATA_" + DigestUtils.md5Hex(paramStr);
        return redisKey;
    }

    //we will not handle cash store here, because we can not get data here
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
