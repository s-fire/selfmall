package org.gly.fmmall.config;

import org.gly.fmmall.interceptor.CheckTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    CheckTokenInterceptor checkTokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(checkTokenInterceptor).addPathPatterns("/**").excludePathPatterns("/user/register","/user/login");
    }

}
