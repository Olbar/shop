package org.levelup.shop.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

@Bean
    public ModelMapper modelmapper(){
    return new ModelMapper();

}
}
