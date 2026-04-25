package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DBConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testEnvVarsInjectedIntoDataSource() throws Exception {
        // Verify DataSource is not null
        assertThat(dataSource).isNotNull();

        // Print resolved values for Jenkins console output
        System.out.println("DB_URL: " + dataSource.getConnection().getMetaData().getURL());
        System.out.println("DB_USER: " + dataSource.getConnection().getMetaData().getUserName());

        // Simple query to confirm connection
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testTableInsertAndQuery() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS sample (id INT PRIMARY KEY, name VARCHAR(50))");
        jdbcTemplate.update("INSERT INTO sample (id, name) VALUES (?, ?)", 1, "Rohan");

        String name = jdbcTemplate.queryForObject("SELECT name FROM sample WHERE id = 1", String.class);
        assertThat(name).isEqualTo("Rohan");
    }
}