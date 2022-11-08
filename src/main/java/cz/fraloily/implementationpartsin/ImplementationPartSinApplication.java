package cz.fraloily.implementationpartsin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImplementationPartSinApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ImplementationPartSinApplication.class, args);
        context.getBean(TestService.class)
                .testAuthor()
                .testPublisher();
    }

}
