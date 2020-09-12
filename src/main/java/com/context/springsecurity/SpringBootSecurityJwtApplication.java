package com.context.springsecurity;

import com.context.springsecurity.domain.ERole;
import com.context.springsecurity.domain.Role;
import com.context.springsecurity.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.context.*")
@ComponentScan
public class SpringBootSecurityJwtApplication {

    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            for (ERole eRole : ERole.values()) {
                if (!roleRepository.existsByName(eRole)) {
                    roleRepository.save(new Role(eRole));
                }
            }

        };
    }


}
