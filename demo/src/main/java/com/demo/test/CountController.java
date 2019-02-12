package com.demo.test;

import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author : chenjie
 * @date : 2018-12-18 16:21
 * @describe :
 */
@RestController
@RequestMapping("/count")
public class CountController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/add")
    @Transactional
    public String add() {
        Item one = Item.builder().item_name("BMI").score(52).unit("bmi").build();
        Item two = Item.builder().item_name("肺活量").score(75).unit("cc").build();
        Item three = Item.builder().item_name("跳高").score(74).unit("cm").build();
        ArrayList<Item> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        PT pt1 = PT.builder().class_id("20150102").class_name("二班").school_id("0801").school_name("实验小学").grade_id("201501").grade_name("2015年级")
                .batch("2014-10-15").student_Id("01").student_name("feey").test_time(new Date()).items(list).build();
        mongoTemplate.insert(pt1);
        System.out.println(1 / 0);
        mongoTemplate.insert(pt1);
        return "add";
    }

    /**
     * Q1.统计各个年级人数
     **/
    @GetMapping("/one")
    public String one() {
        Aggregation agg = Aggregation.newAggregation(Aggregation.group("grade_name").count().as("total")
                ,Aggregation.project("total").and("gradeName").previousOperation());
        AggregationResults<AggDto> pt = mongoTemplate.aggregate(agg, "pt", AggDto.class);

        List<AggDto> list = pt.getMappedResults();
        System.out.println(list);
        return "ok";
    }

    /** 统计某个年级某一项测试在某个范围的人数 **/
    @GetMapping("/two")
    public String two() {
        Aggregation agg = Aggregation.newAggregation(Aggregation.unwind("items"), Aggregation.match(Criteria.where("items.item_name").is("BMI")),
                Aggregation.group("grade_name").count().as("BMI正常人数"));
        AggregationResults<Document> pt = mongoTemplate.aggregate(agg, "pt", Document.class);
        System.out.println(pt);
        return "ok";
    }
}
