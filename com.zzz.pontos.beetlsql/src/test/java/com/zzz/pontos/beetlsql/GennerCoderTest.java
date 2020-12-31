package com.zzz.pontos.beetlsql;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.core.ReThrowConsoleErrorHandler;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.H2Style;
import org.beetl.sql.ext.DBInitHelper;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.gen.SourceBuilder;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.ConsoleOnlyProject;
import org.beetl.sql.gen.simple.EntitySourceBuilder;
import org.beetl.sql.gen.simple.MDSourceBuilder;
import org.beetl.sql.gen.simple.MapperSourceBuilder;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GennerCoderTest
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/31
 * @Version 1.0.0
 */
public class GennerCoderTest {
    SQLManager sqlManager ;
    {
        HikariDataSource ds = new HikariDataSource();
        //内存数据库
        ds.setJdbcUrl("jdbc:h2:mem:dbtest;DB_CLOSE_ON_EXIT=FALSE");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setDriverClassName("org.h2.Driver");
        //得到一个ConnectionSource， 单数据源
        ConnectionSource source = ConnectionSourceHelper.getSingle(ds);
        //SQLManagerBuilder 唯一必须的参数就是ConnectionSource
        SQLManagerBuilder builder = new SQLManagerBuilder(source);
        //命名转化，数据库表和列名下划线风格，转化成Java对应的首字母大写，比如create_time 对应ceateTime
        builder.setNc(new UnderlinedNameConversion());
        //拦截器，非必须，这里设置一个debug拦截器，可以详细查看执行后的sql和sql参数
        builder.setInters(new Interceptor[]{new DebugInterceptor()});
        //数据库风格，因为用的是H2,所以使用H2Style,
        builder.setDbStyle(new H2Style());
        SQLManager sqlManager = builder.build();
       this.sqlManager = sqlManager;
    }
@Test
    public void  genTest() {
    DBInitHelper.executeSqlScript(sqlManager,"db/schema.sql");
        List<SourceBuilder> sourceBuilder = new ArrayList<>();
        SourceBuilder entityBuilder = new EntitySourceBuilder();
        SourceBuilder mapperBuilder = new MapperSourceBuilder();
        SourceBuilder mdBuilder = new MDSourceBuilder();

        sourceBuilder.add(entityBuilder);
        sourceBuilder.add(mapperBuilder);
        sourceBuilder.add(mdBuilder);

        SourceConfig config = new SourceConfig(sqlManager,sourceBuilder);
//如果有错误，抛出异常而不是继续运行1
        EntitySourceBuilder.getGroupTemplate().setErrorHandler(new ReThrowConsoleErrorHandler() );

        ConsoleOnlyProject project = new ConsoleOnlyProject();
        String tableName = "sys_user";
//可以在控制台看到生成的所有代码
        config.gen(tableName,project);
    }
}
