package io.github.paulovieirajr.mscartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCartoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCartoesApplication.class, args);
    }

}
