package vn.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.codegym.dto.ContractDetailDto;
import vn.codegym.dto.ContractDto;
import vn.codegym.dto.CustomerDto;

@SpringBootApplication
public class CaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyApplication.class, args);
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("123");
        System.out.println(pass);
    }
}
