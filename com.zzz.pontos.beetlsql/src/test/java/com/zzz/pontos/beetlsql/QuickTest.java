package com.zzz.pontos.beetlsql;

import com.zaxxer.hikari.HikariDataSource;
import com.zzz.pontos.beetlsql.entity.UserInfo;
import org.beetl.sql.clazz.TableDesc;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.H2Style;
import org.beetl.sql.ext.DBInitHelper;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.mapper.BaseMapper;

import javax.sql.DataSource;
import java.util.*;

/**
 * @ClassName QuickTest
 * @Description TODO
 * @Author zhengzz
 * Date 2020/12/30
 * @Version 1.0.0
 */
public class QuickTest {
    private static DataSource datasource() {
        HikariDataSource ds = new HikariDataSource();
        //内存数据库
        ds.setJdbcUrl("jdbc:h2:mem:dbtest;DB_CLOSE_ON_EXIT=FALSE");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setDriverClassName("org.h2.Driver");
        return ds;
    }

    private  static SQLManager getSQLManager(){
        //得到一个数据源
        DataSource dataSource = datasource();
        //得到一个ConnectionSource， 单数据源
        ConnectionSource source = ConnectionSourceHelper.getSingle(dataSource);
        //SQLManagerBuilder 唯一必须的参数就是ConnectionSource
        SQLManagerBuilder builder = new SQLManagerBuilder(source);
        //命名转化，数据库表和列名下划线风格，转化成Java对应的首字母大写，比如create_time 对应ceateTime
        builder.setNc(new UnderlinedNameConversion());
        //拦截器，非必须，这里设置一个debug拦截器，可以详细查看执行后的sql和sql参数
        builder.setInters(new Interceptor[]{new DebugInterceptor()});
        //数据库风格，因为用的是H2,所以使用H2Style,
        builder.setDbStyle(new H2Style());
        SQLManager sqlManager = builder.build();
        return sqlManager;
}
    public static void main(String[] args) throws Exception {
        SQLManager sqlManager = getSQLManager();
        //初始化数据脚本，执行后，内存数据库将有一个sys_user表和模拟数据
        DBInitHelper.executeSqlScript(sqlManager,"db/schema.sql");
        // 得到数据库的所有表
        Set<String> all =  sqlManager.getMetaDataManager().allTable();
        TableDesc desc =sqlManager.getMetaDataManager().getTable("sys_user");
        Arrays.asList(desc.getCols().toArray()).forEach(System.out::println);
        System.out.println(all);
        // 主键查询
        UserInfo user  = sqlManager.unique(UserInfo.class,1);
        System.out.println(user.toString());
        //按照模板查询
        UserInfo template = new UserInfo();
        template.setDepartmentId(1);
        List<UserInfo> list = sqlManager.template(template);
        list.forEach(System.out::println);

        //执行SQL
        String sql = "select * from sys_user where id=?";
        Integer id  = 1;
        SQLReady sqlReady = new SQLReady(sql,new Object[]{id});
        List<UserInfo> userEntities = sqlManager.execute(sqlReady,UserInfo.class);

        String updateSql = "update sys_user set name=? where id =?";
        String name="lijz";
        SQLReady updateSqlReady = new SQLReady(updateSql,new Object[]{name,id});
        sqlManager.executeUpdate(updateSqlReady);
        // 模板SQL
         sql = "select * from sys_user where department_id=#{id} and name=#{name}";
        UserInfo paras = new UserInfo();
        paras.setDepartmentId(1);
        paras.setName("lijz");
        list = sqlManager.execute(sql,UserInfo.class,paras);

        //TODO Map类型
        /* sql = "select * from sys_user where department_id=#{myDeptId} and name=#{myName}";
        Map parasmap = new HashMap();
        parasmap.put("myDeptId",1);
        parasmap.put("myName","lijz");
        list = sqlManager.execute(sql,UserInfo.class,paras);*/

        //TODO 文件模板
        BaseMapper
    }
}
