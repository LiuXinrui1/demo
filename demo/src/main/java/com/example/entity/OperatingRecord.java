package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月01日 19:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OperatingRecord implements Serializable {
    private String name;

    private String operate;

    private String source;

    private String message;

    private String time;

    private String ip;

    private String permission;
}
