package cz.fraloily.implementationpartsin;

import cz.fraloily.implementationpartsin.interceptor.RequestLengthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    final
    RequestLengthInterceptor requestLengthInterceptor;

    public WebMvcConfig(
            @Autowired RequestLengthInterceptor requestLengthInterceptor
    ) {
        this.requestLengthInterceptor = requestLengthInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(requestLengthInterceptor);
    }

}
