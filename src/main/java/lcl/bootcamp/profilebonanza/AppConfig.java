package lcl.bootcamp.profilebonanza;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("ab")
    WrapperClass getMeAbString() {
        return new WrapperClass("AB");
    }

    @Bean
    @Profile("sk")
    WrapperClass getMeSkString() {
        return new WrapperClass("SK");
    }

    @AllArgsConstructor
    @Data
    public class WrapperClass {
        String province;
    }

}
