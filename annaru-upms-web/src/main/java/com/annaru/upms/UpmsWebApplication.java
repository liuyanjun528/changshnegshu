package com.annaru.upms;

import com.annaru.upms.netty.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author TuMinglong
 * @description Application
 * @date 2017年9月5日下午8:55:08
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
@ComponentScan("com.annaru")
public class UpmsWebApplication extends SpringBootServletInitializer implements CommandLineRunner {
    protected final static Logger logger = LoggerFactory.getLogger(UpmsWebApplication.class);

    @Autowired
    private NettyServer server;


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("----UpmsWebApplication 启动----");
        return application.sources(UpmsWebApplication.class);

    }

    public static void main(String[] args) {
        SpringApplication.run(UpmsWebApplication.class, args);
        logger.info("----UpmsWebApplication 启动----");
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        System.out.println("Netty =======》run  .... . ... ");
    }

}
