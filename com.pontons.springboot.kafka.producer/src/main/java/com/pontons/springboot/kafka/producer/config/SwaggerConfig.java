package com.pontons.springboot.kafka.producer.config;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className SwaggerConfig
 * @description TODO
 * @date 2022/4/19
 */
public class SwaggerConfig{

}
/*
public class SwaggerConfig implements WebFluxConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("业余草 project")
                        .title("业余草 RESTful APIs")
                        .termsOfServiceUrl("https://www.xttblog.com/")
                        .contact(new Contact("业余草", "https://www.xttblog.com/", "1139057136@qq.com"))
                        .version("1.0.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pontons.springboot.kafka.producer.controller"))
                .paths(PathSelectors.any())
                .build()
                .genericModelSubstitutes(Optional.class, Flux.class, Mono.class);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置跨域
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTION", "DELETE").maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 重新映射路径
        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);

        registry.addResourceHandler("/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/").resourceChain(true);
    }

}
*/
