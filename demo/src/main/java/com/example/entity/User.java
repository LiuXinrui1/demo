package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-11-24 09:40:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 153569635586840874L;

    private String user_name;

    private String user_password;

    private String permission_name;

    private String user_phone;

    private String functions;

    private String status;

}