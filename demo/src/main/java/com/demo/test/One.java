package com.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author : chenjie
 * @date : 2018-12-24 9:42
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("test")
public class One {
    private String id;

    private Integer age;

    @Field("user_name")
    private String userName;
}
