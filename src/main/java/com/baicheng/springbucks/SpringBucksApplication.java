package com.baicheng.springbucks;

import com.baicheng.springbucks.enums.OrderState;
import com.baicheng.springbucks.model.Coffee;
import com.baicheng.springbucks.model.CoffeeOrder;
import com.baicheng.springbucks.repository.CoffeeRepository;
import com.baicheng.springbucks.service.CoffeeOrderService;
import com.baicheng.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@Slf4j
public class SpringBucksApplication implements ApplicationRunner {

	@Autowired
	private CoffeeRepository coffeeRepository;

	@Autowired
	private CoffeeService coffeeService;

	@Autowired
	private CoffeeOrderService coffeeOrderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBucksApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("All coffee: {}", coffeeRepository.findAll());

		Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
		if (latte.isPresent()){
			CoffeeOrder order = coffeeOrderService.createOrder("baicheng", Collections.singletonList(latte.get()));
			log.info("update init to paid: {}", coffeeOrderService.updateState(order, OrderState.PAID));
			log.info("update paid to init: {}", coffeeOrderService.updateState(order, OrderState.INIT));
		}
	}
}
