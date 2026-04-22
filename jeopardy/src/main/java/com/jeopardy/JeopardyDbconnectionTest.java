package com.jeopardy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class JeopardyDbconnectionTest implements CommandLineRunner {


    private final DataSource dataSource;

    public JeopardyDbconnectionTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Connected to PostgreSQL successfully!");
            } else {
                System.out.println("❌ Connection failed!");
            }
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
