package cz.fraloily.implementationpartsin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ImplementationPartSinApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ImplementationPartSinApplication.class, args);
        context.getBean(TestService.class)
                .testAuthor()
                .testPublisher()
                .testBook();

    }

}
