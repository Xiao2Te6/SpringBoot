package asia.xiaoer.springboot.beans;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : XiaoEr
 * @date : 2023/3/10
 *
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties("car")
public class Car {

    private String name;
    private Integer price;
}
