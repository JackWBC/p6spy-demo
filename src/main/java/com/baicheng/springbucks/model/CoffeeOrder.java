package com.baicheng.springbucks.model;

import com.baicheng.springbucks.enums.OrderState;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author baicheng
 * @description
 * @create 2019-03-01 16:46
 */
@Entity
@Table(name = "t_order")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 4609740390683813841L;

    private String customer;

    @ManyToMany
    @JoinTable(name = "t_order_coffee")
    @OrderBy("id")
    private List<Coffee> items;

    @Enumerated
    @Column(nullable = false)
    private OrderState state;
}
