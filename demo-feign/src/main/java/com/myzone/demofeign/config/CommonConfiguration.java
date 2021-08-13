package com.myzone.demofeign.config;

import com.myzone.demofeign.interceptor.FeignUserContextInterceptor;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@EnableWebMvc
public class CommonConfiguration {
	
    /**
     * 创建Feign请求拦截器，在发送请求前设置认证的用户上下文信息
     */
    @Bean
    @ConditionalOnClass(Feign.class)
    public FeignUserContextInterceptor feignTokenInterceptor() {
        return new FeignUserContextInterceptor();
    }

    /**
     * RestTemplate拦截器
     * @return
     */
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
////        restTemplate.getInterceptors().add(new RestTemplateUserContextInterceptor());
//        return restTemplate;
//    }
   
}
