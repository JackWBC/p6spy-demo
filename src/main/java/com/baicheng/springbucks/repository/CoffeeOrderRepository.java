package com.baicheng.springbucks.repository;

import com.baicheng.springbucks.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author baicheng
 * @description
 * @create 2019-03-01 16:55
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
