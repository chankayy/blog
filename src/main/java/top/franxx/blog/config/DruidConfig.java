package top.franxx.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(
        // 此处的mapper 可以有多个
        basePackages = { DruidConfig.MAPPER_PACKAGE },
        sqlSessionFactoryRef = "baseSqlSessionTemplate"
)
public class DruidConfig {

    // mapper 的xml存放路径
    protected final static String MAPPER_XML_AREA = "classpath:top/franxx/blog/mapper/*.xml";
    // mapper.java 存放路径，被@MapperScan扫描的，注入 sqlsession的
    protected final static String MAPPER_PACKAGE = "top.franxx.blog.mapper";

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;


    /**
     * 注入 datasource
     *
     * @return
     */
    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.base")
    @Primary
    public DataSource setDataSource() {
        // 使用druid 则这样注入 dataSource，不需要则直接 DataSourceBuilder.create().build()
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        try {
            // 如果想使用 Druid 的sql监控则，此处需要写 stat
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

/*
    */
/**
     * 注入 事务，在 serviceImpl 的时候使用
     *
     * @return
     *//*

    @Bean(name = "baseTransationManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager() {
        // 传入 dataSource
        return new DataSourceTransactionManager(setDataSource());
    }
*/

    /**
     * 注入 sqlSession
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionFactory setSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(setDataSource());
        // 设置mapper.xml 扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DruidConfig.MAPPER_XML_AREA));
        return bean.getObject();
    }

}