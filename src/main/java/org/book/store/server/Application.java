package org.book.store.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.book.store")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
