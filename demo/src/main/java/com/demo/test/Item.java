package com.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : chenjie
 * @date : 2018-12-18 16:19
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    /** 项目名称 **/
    private String item_name;

    /** 分数 **/
    private double score;

    /** 单位 **/
    private String unit;
}
