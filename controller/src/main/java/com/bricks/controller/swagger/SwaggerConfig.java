package com.bricks.controller.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Swagger config.
 *
 * @author xu
 * @date 2020.05.20
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * Create rest api docket.
     *
     * @return the docket
     * @author xu
     * @date 2020.05.20
     */
    @Bean
    public Docket createRestApi() {
        //构建文档
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        //文档信息
        Docket build = docket.apiInfo(apiInfo())
                //查询
                .select()
                // 注解包的路径
                .apis(RequestHandlerSelectors.basePackage("com.bricks.controller"))
                // 任何路径
                .paths(PathSelectors.any())
                .build();
        return build;
    }


    private ApiInfo apiInfo() {
        // 文档对象构建器
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        // 文档标题
        return apiInfoBuilder.title("Demo API doc by XuRao")
                // 描述信息
                .description("this is a demo")
                // 版本号
                .version("v1")
                // 联系人
                .contact(new Contact("XuRao", "https://xurao", "xrxurao@163.com"))
                // 声明许可
                .license("这是个声明许可")
                // 许可路径，这边是我的github
                .licenseUrl("https://xurao")
                .build();
    }

}
