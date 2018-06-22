# 基于位置服务的移动端学生签到系统
后台采用spring boot + swagger2开发

## Druid配置

在Spring Boot中使用Druid，主要有以下步骤：
> 1.项目中引入druid-spring-boot-starter依赖。
> 
```xml
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid-spring-boot-starter</artifactId>
  <version>1.1.5</version>
</dependency>
```

> 2.在application.properties中新增数据库连接池配置。
>
```properties
# 配置数据源
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
# mysql
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/attendance?useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.username=
spring.datasource.password=

# connector pool configuration
# 连接池启动时创建的连接数量的初始值
spring.datasource.initialSize=5
# 最小空闲值，当空闲的连接数少于阀值时，连接池就会去预申请连接
spring.datasource.minIdle=5
# 连接池的最大值，同一时间可以从连接池分配的最多连接数量 
spring.datasource.maxActive=20
# 配置获取连接等待超时的时间
spring.datasource.maxWait=60000

# 配置监控统计拦截的filters，用于监控SQL，wall用于防火墙
spring.datasource.filters=stat,wall
```

> 3.定义Filter，忽略静态资源的拦截。
>
```java
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", 
    initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
    }
)
public class DruidStatFilter extends WebStatFilter {
}
```
> 4.定义Servlet，用于Druid控制台的查看。
>
```java
@WebServlet(urlPatterns = "/druid/*", initParams = {
   @WebInitParam(name = "allow", value = "192.168.16.110,127.0.0.1"), // IP白名单 (没有配置或者为空，则允许所有访问)
   @WebInitParam(name="deny",value="192.168.16.111"), // IP黑名单 (存在共同时，deny优先于allow)
   @WebInitParam(name = "loginUsername", value = "qianlq"),// 用户名
   @WebInitParam(name = "loginPassword", value = "qlq1995/"),// 密码
   @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
   }
)
public class DruidStatViewServlet extends StatViewServlet {
}
```

> 5.在启动类上添加@ServletComponentScan注解
> 
> Druid搭建好以后，通过 http://localhost:8080/druid/index.html 进行正常访问。但是可能在SQL监控界面并没有监控数据，这种情况只要手动初始化Druid DataSource即可。
>
```java
@Bean
@Primary
public DataSource dataSource() {
  DruidDataSource datasource = new DruidDataSource();
  return datasource;
}
```

## swagger2配置
在Spring Boot中使用swagger，主要有以下步骤：
> 1.项目中引入springfox-swagger2和springfox-swagger2-ui依赖。
> 
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>

<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.7.0</version>
</dependency>
```
> 2.配置自定义拦截器
> 
```java
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //PrettyFormat:结果是否格式化,默认为false
        //WriteMapNullValue:是否输出值为null的字段,默认为false
        //DisableCircularReferenceDetect:消除对同一对象循环引用的问题，默认为false
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.DisableCircularReferenceDetect
        );

        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }
}
```

> 3.配置swagger页面
> 
```java
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
		//ParameterBuilder tokenPar = new ParameterBuilder();
		//List<Parameter> pars = new ArrayList<>();
		//tokenPar.name("x-access-token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		//pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.qianlq.attendance.controller"))
            .paths(PathSelectors.any())
            .build()
			//.globalOperationParameters(pars)
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("签到系统")
            .description("签到系统")
            .termsOfServiceUrl("http://cn.qianlq")
            .version("1.0")
            .build();
    }
}
```

