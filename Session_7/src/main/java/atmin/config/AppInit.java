package atmin.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    @NullMarked
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.@NonNull Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        "",
                        25 * 1024 * 1024L,  // maxFileSize: 25MB (Giới hạn 1 file)
                        50 * 1024 * 1024L,  // maxRequestSize: 50MB (Tổng dung lượng request)
                        0                   // fileSizeThreshold: 0 (Ghi thẳng vào đĩa ngay lập tức)
                )
        );
    }
}
