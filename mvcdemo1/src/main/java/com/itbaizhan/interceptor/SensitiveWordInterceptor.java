package com.itbaizhan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

// 敏感词拦截器
public class SensitiveWordInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 敏感词列表
        String[] sensitiveWords = {"坏人","暴力","笨蛋"};
        // 获取model中所有数据
        Map<String, Object> model = modelAndView.getModel();
        Set<Map.Entry<String, Object>> entries = model.entrySet();


        // 遍历model
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            // 将model值和敏感词列表遍历比对
            for (String sensitiveWord : sensitiveWords) {
                // 如果model值包含敏感词，则替换
                if(value.contains(sensitiveWord)){
                    String newStr = value.replaceAll(sensitiveWord, "***");
                    model.put(key, newStr);
                }
            }
        }
    }
}
