package atmin.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.NullMarked;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    @NullMarked
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("", 2 * 1024 * 1024L, 2 * 1024 * 1024L, 0)
        );
    }

//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        // maxFileSize: 10MB, maxRequestSize: 15MB
//        long maxFileSize = 10 * 1024 * 1024;
//        long maxRequestSize = 15 * 1024 * 1024;
//        int fileSizeThreshold = 0;
//
//        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
//                null,
//                maxFileSize,
//                maxRequestSize,
//                fileSizeThreshold
//        );
//        registration.setMultipartConfig(multipartConfigElement);
//    }

}


