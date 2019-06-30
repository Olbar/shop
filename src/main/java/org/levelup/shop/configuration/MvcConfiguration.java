package org.levelup.shop.configuration;


import org.levelup.shop.interceptor.CookieSessionInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    public ModelMapper modelmapper(){
    return new ModelMapper();
}
    @Bean
    public CookieSessionInterceptor cookieSessionInterceptor() {
        return new CookieSessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cookieSessionInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/login");
    }
}
