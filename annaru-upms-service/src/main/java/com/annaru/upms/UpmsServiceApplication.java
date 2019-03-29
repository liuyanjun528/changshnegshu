package com.annaru.upms;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.annaru.upms.handle.netty.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author TuMinglong
 * @description Application
 * @date 2017年9月5日下午8:55:08
 */

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
@EnableAsync
@EnableScheduling
@ComponentScan("com.annaru")
public class UpmsServiceApplication extends SpringBootServletInitializer implements CommandLineRunner {
    protected final static Logger logger = LoggerFactory.getLogger(UpmsServiceApplication.class);

    @Autowired
    private NettyServer server;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("----UpmsServiceApplication 启动----");
        return application.sources(UpmsServiceApplication.class);

    }

    public static void main(String[] args) {
        SpringApplication.run(UpmsServiceApplication.class, args);
        logger.info("----UpmsServiceApplication 启动----");
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        System.out.println("Netty =======》run  .... . ... ");
    }

}
