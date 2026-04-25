package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvVarInjectionTest {

    @Test
    void checkEnvVarsInjected() {
        String dbUrl = System.getenv("DB_URL");
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");

        // Print to Jenkins logs
        System.out.println("DB_URL: " + dbUrl);
        System.out.println("DB_USER: " + dbUser);
        System.out.println("DB_PASSWORD: " + dbPassword);

        // Assert they are not null (injected correctly)
        assertNotNull(dbUrl, "DB_URL should be injected");
        assertNotNull(dbUser, "DB_USER should be injected");
        assertNotNull(dbPassword, "DB_PASSWORD should be injected");
    }
}