//package com.myzone.demoshardingjdbc.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//public class DruidConfig {
//
//    @Bean
////    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
////    @Bean
////    public DynamicDataSource dynamicDataSource(DataSourceProperties dataSourceProperties) {
////        DynamicDataSource dynamicDataSource = new DynamicDataSource();
////        dynamicDataSource.setTargetDataSources(getDynamicDataSource());
////
////        //默认数据源
////        DruidDataSource defaultDataSource = DynamicDataSourceFactory.buildDruidDataSource(dataSourceProperties);
////        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
////
////        return dynamicDataSource;
////    }
//}
