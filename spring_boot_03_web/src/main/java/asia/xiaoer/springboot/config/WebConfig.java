package asia.xiaoer.springboot.config;

import asia.xiaoer.springboot.domain.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

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
                //强转原因：必须规定Converter接口的两个泛型类型
                registry.addConverter((Converter<String, Pet>)(source) ->{
                    if (!source.isEmpty()) {
                        String[] split = source.split(",");
                        return new Pet(split[0],Integer.parseInt(split[1]));
                    }
                    return null;
                });
            }
        };



    }






}
