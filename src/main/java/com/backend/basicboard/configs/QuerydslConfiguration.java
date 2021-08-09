package com.backend.basicboard.configs;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslConfiguration {

@PersistenceContext
private final entityManager
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return JPAQueryFactory(entityManager);
    }
}
