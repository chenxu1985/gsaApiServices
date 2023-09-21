package cn.ac.big.bigd.webservice.datasource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 默认数据源配置方法
 * 通过mapperScan扫描该数据源下全部mapper,读取yaml配置文件,注入DataSource,SqlSessionFactory,SqlSessionTemplate
 */
@Configuration
@MapperScan(basePackages = "cn.ac.big.bigd.webservice.mapper.gsa", sqlSessionFactoryRef = "primarySqlSessionFactory")
//扫描对应数据源下mapper url
public class DataSourceConfigGSA {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary//多数据源配置类场景中,必须设置默认数据源,否则启动出错
    @ConfigurationProperties(prefix = "spring.datasource.gsa")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //datasource注入SqlSessionFactory,交给SqlSessionFactory托管
        bean.setDataSource(datasource);
        //扫描对应model url
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage("cn.ac.big.bigd.webservice.model.gsa");
        //扫描对应数据源下mapper.xml url
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/gsa/*.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }
//    @Bean(name = "primaryTransactionManager")
//    @Primary
//    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean("primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }
}