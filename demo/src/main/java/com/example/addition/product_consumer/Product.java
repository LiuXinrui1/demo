package com.example.addition.product_consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月07日 18:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {
    int id;
    String name;
}
