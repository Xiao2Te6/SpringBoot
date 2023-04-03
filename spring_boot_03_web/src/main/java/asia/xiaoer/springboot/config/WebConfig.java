package asia.xiaoer.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
     * 使用@bean开启矩阵变量
     */
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //关闭移除地址分号后的内容（开启矩阵变量）
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
}
