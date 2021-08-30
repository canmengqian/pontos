package com.zzz.pontos.beetlsql.config;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.DBInitHelper;
import org.beetl.sql.starter.SQLManagerCustomize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @ClassName SimpleDataSourceConfig
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/30
 * @Version 1.0.0
 */
@Configuration
public class SimpleDataSourceConfig {
    @Autowired
    ApplicationContext ctx;

    @Primary
    @Bean(name = "ds1")
    public DataSource datasource(Environment env) {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }

    @Bean
    public SQLManagerCustomize mySQLManagerCustomize() {
        return new SQLManagerCustomize() {
            @Override
            public void customize(String sqlMangerName, SQLManager manager) {
                //初始化sql，这里也可以对sqlManager进行修改
                DBInitHelper.executeSqlScript(manager, "db/schema.sql");

            }
        };
    }
}
