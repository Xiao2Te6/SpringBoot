package asia.xiaoer.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : XiaoEr
 * @date : 2023/4/4
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pet {

    private String name;
    private Integer age;
}
