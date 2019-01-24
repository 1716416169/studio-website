package cn.cks.studiowebsite.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebmvcConfig extends WebMvcConfigurationSupport {
    @Value("${web.imgpath_Honor}")
   String imgpath_Honor;

    @Value("${web.imgpath_dynamic}")
    String imgpath_dynamic;
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/people").setViewName("people");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/ico/**").addResourceLocations("classpath:/static/ico/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/imgpath_Honor/**").addResourceLocations("file:"+imgpath_Honor);
        registry.addResourceHandler("/imgpath_dynamic/**").addResourceLocations("file:"+imgpath_dynamic);
        registry.addResourceHandler("swagger-ui.html").addResourceLocations( "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations( "classpath:/META-INF/resources/webjars/");
        System.out.println("荣誉图片上传的真实路径："+imgpath_Honor);
        System.out.println("动态图片上传的真实路径："+imgpath_dynamic);
        registry.addResourceHandler("/gm2.html").addResourceLocations("classpath:/templates/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        //registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/gm","/static","/sql","/bootstrap","/");
        registry.addInterceptor(new Interceptor()).addPathPatterns("/gm_people");
        registry.addInterceptor(new AllowOriginIntercepter()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}

