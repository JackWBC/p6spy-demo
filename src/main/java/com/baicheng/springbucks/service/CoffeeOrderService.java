package com.baicheng.springbucks.service;

import com.baicheng.springbucks.enums.OrderState;
import com.baicheng.springbucks.model.Coffee;
import com.baicheng.springbucks.model.CoffeeOrder;
import com.baicheng.springbucks.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author baicheng
 * @description
 * @create 2019-03-01 17:02
 */
@Service
@Slf4j
@Transactional
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public CoffeeOrder createOrder(String customer, List<Coffee> coffees){
        CoffeeOrder coffeeOrder = CoffeeOrder.builder()
                .customer(customer)
                .items(coffees)
                .state(OrderState.INIT)
                .build();
        CoffeeOrder save = coffeeOrderRepository.save(coffeeOrder);
        log.info("save coffeeOrder: {}", save);
        return save;
    }

    public boolean updateState(CoffeeOrder order, OrderState state){
        if (state.compareTo(order.getState()) <= 0){
            log.info("wrong order state: {} {}", state, order);
            return false;
        }
        order.setState(state);
        CoffeeOrder save = coffeeOrderRepository.save(order);
        log.info("modify order state: {}", save);
        return true;
    }
}
