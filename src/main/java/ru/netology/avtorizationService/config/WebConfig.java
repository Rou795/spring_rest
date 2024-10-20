package ru.netology.avtorizationService.config;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.avtorizationService.advice.QuerryArgumentResolver;

import java.util.List;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new QuerryArgumentResolver());
    }
}
