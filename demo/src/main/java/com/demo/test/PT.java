package com.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : chenjie
 * @date : 2018-12-18 16:18
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("pt")
public class PT implements Serializable{
    @Id
    private String id;

    /**学生id **/
    private String student_Id;

    /** 学生姓名 **/
    private String student_name;

    /** 学校id **/
    private String school_id;

    /** 学校名称 **/
    private String school_name;

    /** 年级id **/
    private String grade_id;

    /** 年级名称 **/
    private String grade_name;

    /** 班级id **/
    private String class_id;

    /** 班级名称 **/
    private String class_name;

    /** 批次 **/
    private String batch;

    /** 测试时间 **/
    private Date test_time;

    /** 项目 **/
    private List<Item> items;

}
