package edu.nwafu.paper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"edu.nwafu.paper.mapper"})
public class PaperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperApplication.class, args);
    }
}
