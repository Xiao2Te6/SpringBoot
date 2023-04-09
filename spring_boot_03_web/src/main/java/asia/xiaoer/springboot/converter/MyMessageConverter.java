package asia.xiaoer.springboot.converter;

import asia.xiaoer.springboot.domain.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * @author : XiaoEr
 * @date : 2023/4/9
 */
public class MyMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }


    //返回当前converter能写出的所有媒体类型
    // application/p-xiaoer
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/p-xiaoer");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    //将自定义协议内容写出
    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议
        String data = person.getName() + "; " + person.getAge() + "; " + person.getGender() + "; [" +
                      person.getPet().getName() + "; " + person.getAge() + "]";
        //写出
        outputMessage.getBody().write(data.getBytes());
    }
}
