package com.test.jooqtest.config;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JooqConfig {

    private final DataSource dataSource;

    @Bean
    public DSLContext dslContext() {
        Settings settings = new Settings()
                .withBatchSize(10000);
        return DSL.using(dataSource, SQLDialect.MYSQL);
    }

}
