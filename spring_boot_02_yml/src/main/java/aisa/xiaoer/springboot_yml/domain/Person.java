package aisa.xiaoer.springboot_yml.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : XiaoEr
 * @date : 2023/3/27
 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Double> score;
    private Set<Double> salary;
    private Map<String, List<Pet>> allPets;

}
