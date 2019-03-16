package com.baicheng.springbucks.service;

import com.baicheng.springbucks.model.Coffee;
import com.baicheng.springbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * @author baicheng
 * @description
 * @create 2019-03-01 16:56
 */
@Service
@Slf4j
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Optional<Coffee> findOneCoffee(String name){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());

        Optional<Coffee> coffeeOptional = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(), exampleMatcher));

        log.info("coffee found: {} {}", name, coffeeOptional);
        return coffeeOptional;
    }
}
