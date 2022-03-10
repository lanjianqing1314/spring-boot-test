package com.example.demoredisorm.domain;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 * @TableName user
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(language = "chinese")
public class User {
    /**
     * 
     */
    @Id
    private Long id;

    /**
     * 
     */
    @Searchable
    private String name;

    /**
     * 
     */
    @Indexed
    private Integer age;

}