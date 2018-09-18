package com.concretepage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//(scanBasePackages= {"com.concretepage","com.concretepage.entity","com.concretepage.controller",
	//	"com.concretepage.repository","com.concretepage.service"})
//@ComponentScan({"com.concretepage.service"})
public class MyApplication {  
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }
}            