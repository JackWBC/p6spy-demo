package com.baicheng.springbucks.repository;

import com.baicheng.springbucks.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author baicheng
 * @description
 * @create 2019-03-01 16:52
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
