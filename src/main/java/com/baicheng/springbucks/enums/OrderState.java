package com.baicheng.springbucks.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author baicheng
 * @description
 * @create 2019-03-01 16:40
 */
@AllArgsConstructor
@Getter
public enum OrderState {
    INIT(0, "init"),
    PAID(1, "paid"),
    BREWING(2, "brewing"),
    BREWED(3, "brewed"),
    TAKEN(4, "taken"),
    CANCELLED(5, "cancelled");

    private int code;
    private String name;
}
