package asia.xiaoer.springboot.beans;

import lombok.*;

/**
 * @author : XiaoEr
 * @date : 2023/3/10
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Cat cat;

}
