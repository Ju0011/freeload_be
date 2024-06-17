package ju00.freeload.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = ObjectUtils.asMap(
                "cloud_name", "dvlxjfr1t",
                "api_key", "649914571821991",
                "api_secret", "QNhatzd8sdrFyGv1Wc61_D_3r4c");
        return new Cloudinary(config);
    }
}
