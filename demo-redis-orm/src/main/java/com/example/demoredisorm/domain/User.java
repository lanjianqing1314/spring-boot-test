package com.example.demoredisorm.domain;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document
public class User implements Serializable {
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