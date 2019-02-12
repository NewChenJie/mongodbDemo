package com.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : chenjie
 * @date : 2018-12-18 11:25
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "new")
public class User {

    private String cid;

    private String name;

    private Integer age;

    private Long tall;

}
