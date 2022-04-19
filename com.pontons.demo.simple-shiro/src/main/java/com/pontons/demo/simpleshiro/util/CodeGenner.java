package com.pontons.demo.simpleshiro.util;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.*;
import org.beetl.sql.gen.BaseProject;
import org.beetl.sql.gen.SourceBuilder;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.*;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class CodeGenner {

    public static DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource ();
        hikariDataSource.setDriverClassName ("com.mysql.jdbc.Driver");
        hikariDataSource.setJdbcUrl ("jdbc:mysql://192.168.0.6:3306/media?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        hikariDataSource.setPassword ("rootroot");
        hikariDataSource.setUsername ("root");
        return hikariDataSource;
    }

    public static void genner() {
        BaseProject baseProject = new StringOnlyProject ();
        baseProject.setRoot ("com.pontons.demo.simpleshiro");
        ConnectionSource connectionSource = ConnectionSourceHelper.getSingle (dataSource ());
        SQLManager sqlManager = new SQLManagerBuilder (connectionSource).build ();
        sqlManager.setNc (new UnderlinedNameConversion ());
        List<SourceBuilder> sourceBuilder = new ArrayList<> ();
        SourceBuilder entityBuilder = new EntitySourceBuilder ();
        SourceBuilder mapperBuilder = new MapperSourceBuilder ();
        SourceBuilder mdBuilder = new MDSourceBuilder ();
        //数据库markdown文
        SourceBuilder docBuilder = new MDDocBuilder ();
        sourceBuilder.add (entityBuilder);
        sourceBuilder.add (mapperBuilder);
        sourceBuilder.add (mdBuilder);
        sourceBuilder.add (docBuilder);
        SourceConfig config = new SourceConfig (sqlManager, sourceBuilder);
        //只输出到控制台
        SimpleMavenProject simpleMavenProject = new SimpleMavenProject ();

        simpleMavenProject.setBasePackage ("com.pontons.demo.simpleshiro");
        String tableName = "sys_role_permission";
        config.gen (tableName, simpleMavenProject);
    }

    public static void main(String[] args) {
        genner ();
    }
}
