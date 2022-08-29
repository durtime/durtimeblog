package my.study.durtimeblog;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("my.study.durtimeblog.mapper")
public class DurtimeblogApplication {
    private final static Logger LOGGER = LoggerFactory.getLogger(DurtimeblogApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(DurtimeblogApplication.class, args);
        LOGGER.info("项目启动:http://localhost:8080/");
        LOGGER.info("项目测试:http://localhost:8080/swagger-ui/index.html");

    }

}
