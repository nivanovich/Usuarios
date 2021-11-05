package com.evaluacion.ntt;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
@Configuration // (1)
public class DozerMapper {
    @Bean  // (2)
    public Mapper beanMapper() {
        return new DozerBeanMapper();  // (3)
    }
}