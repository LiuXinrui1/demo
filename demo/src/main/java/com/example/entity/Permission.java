package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月01日 17:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Permission implements Serializable {
    private String permission_name;

    private String functions;

}
