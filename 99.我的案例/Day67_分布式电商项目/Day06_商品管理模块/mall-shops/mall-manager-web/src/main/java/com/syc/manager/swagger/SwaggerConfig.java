package com.syc.manager.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的配置类
 */
@Configuration //必须有,使得Spring来加载实例化该类!
@EnableSwagger2 //必须有,开启Swagger2功能
@EnableWebMvc //必须有,如果想要启用MVC的Java配置方式,添加该注解
public class SwaggerConfig {

    /**
     * @Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，
     * 也可以用在@Component注解的类里。添加的bean的id为方法名.
     * 用来创建一个Bean.
     * Docket:摘要.
     */
    @Bean
    public Docket createRestApi(){
        System.out.println("docket创建....");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .select()// 选择哪些路径和api会生成document
                //.apis(RequestHandlerSelectors.basePackage("com.syc.manager.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())// 对所有路径进行监控
                .build();
    }

    //创建Api文档对象
    private ApiInfo createApiInfo() {
        System.out.println("apiInfo创建....");
        return new ApiInfoBuilder()
                .title("Mall商城Restful_API文档")
                .description("Mall商城API文档")
                //.termsOfServiceUrl("www.syc.com")//termsOfServiceUrl和contact可以用Contact的对象代替
                //Contact对象中name表示作者，url通常作为项目的链接，代替之前的termsOfServiceUrl方法
                .contact(new Contact("yyg","http://2312119590@qq.com","2312119590@qq.com"))
                .version("1.0.0")
                .build();
    }
}
