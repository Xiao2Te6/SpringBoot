package asia.xiaoer.springboot.config;

import asia.xiaoer.springboot.converter.MyMessageConverter;
import asia.xiaoer.springboot.domain.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.MimeType;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : XiaoEr
 * @date : 2023/4/1
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig{

    /**
     * 修改请求方式过滤器默认_method参数名为 _m
     * @return
     */
    // @Bean
    // public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
    //     HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
    //     hiddenHttpMethodFilter.setMethodParam("_m");
    //     return hiddenHttpMethodFilter;
    // }

    /**
     * webMvc配置
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){

            //自定义内容协商管理器
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                //指定使用参数的内容协商策略能支持的媒体类型
                Map<String, MediaType> mediaTypes = new HashMap<>();
                //添加原本默认的类型
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_XML);
                //添加自定义类型
                mediaTypes.put("xiaoer", MediaType.parseMediaType("application/p-xiaoer"));

                //使用参数的内容协商管理器
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                // 将策略中的参数由 "format" 改为 "fm"
                // parameterContentNegotiationStrategy.setParameterName("fm");

                //使用请求头accept参数的内容协商管理器（添加自定义内容协商管理器会替换掉spring自己的内容协商管理器，从而需要添加原有的功能）
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                //添加内容协商策略
                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy, headerContentNegotiationStrategy));
            }

            //添加扩展的自定义Converter
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
               converters.add(new MyMessageConverter());
            }

            //使用@bean开启矩阵变量（另一种方法是继承WebMvcConfigurerComposite重写configurePathMatch）
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //关闭移除地址分号后的内容（开启矩阵变量）
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

             //添加使用自定义Converter 将'huahua，2'格式字符串转换为pet实体类
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if (!source.isEmpty()) {
                            String[] split = source.split(",");
                            return new Pet(split[0],Integer.parseInt(split[1]));
                        }
                        return null;
                    }
                });
            }
        };



    }






}
