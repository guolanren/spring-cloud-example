package name.guolanren.feign;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author guolanren
 */
@FeignClient(value = "upload-file", configuration = UploadService.UploadFeignClientsConfiguration.class)
public interface UploadService {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file);

    class UploadFeignClientsConfiguration {

        @Bean
        public Encoder uploadEncoder() {
            return new SpringFormEncoder();
        }
    }
}
