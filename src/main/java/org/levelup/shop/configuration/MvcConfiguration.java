package org.levelup.shop.configuration;


import org.levelup.shop.interceptor.CookieSessionInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Value("${shop.attachments.avatars}")
    private String avatarPath;

    @Bean
    public ModelMapper modelmapper() {
        return new ModelMapper();
    }

    @Bean
    public CookieSessionInterceptor cookieSessionInterceptor() {
        return new CookieSessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( cookieSessionInterceptor() )
                .addPathPatterns( "/*" )
                .excludePathPatterns( "/login","/registration","/categories","/categories/*","/about");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/avatars/**" )
                .addResourceLocations( "file:" + avatarPath );
    }
}
