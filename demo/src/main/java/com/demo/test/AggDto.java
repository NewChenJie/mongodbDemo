package com.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2018-12-24 15:58
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggDto {

    private Integer total;

    private String gradeName;
}
