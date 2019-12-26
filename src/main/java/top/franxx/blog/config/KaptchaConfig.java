package top.franxx.blog.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha(){

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border","no");
        properties.setProperty("kaptcha.noise.color","blue");
        properties.setProperty("kaptcha.textproducer.font.color","black");
/*        properties.setProperty("kaptcha.background.clear.from","green");
        properties.setProperty("kaptcha.background.clear.to","red");*/
        properties.setProperty("kaptcha.textproducer.char.space","5");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.put("kaptcha.textproducer.font.size", "35");
        properties.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        // 添加阴影
        properties.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        // 设置图片宽度
        properties.setProperty("kaptcha.image.width", "116");
        // 设置图片高度
        properties.setProperty("kaptcha.image.height", "36");
        Config config = new Config(properties);

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}

