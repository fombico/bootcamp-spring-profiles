package lcl.bootcamp.profilebonanza.lookup;

import lcl.bootcamp.profilebonanza.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("sk")
public class SKProvinceLookup implements ProvinceLookup {
    private final String province;
    private final String color;
    private final AppConfig.WrapperClass wrapperClass;

    public SKProvinceLookup(@Value("${province}") String province,
                            @Value("${color}") String color,
                            AppConfig.WrapperClass wrapperClass) {
        this.province = province;
        this.color = color;
        this.wrapperClass = wrapperClass;
    }

    @Override
    public String getProvinceName() {
        return province;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getProvinceCode() {
        return wrapperClass.getProvince();
    }
}
