package com.example.demomybatiswebflux.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
@Data
public class UserVO implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    private static final long serialVersionUID = 1L;
}