package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : chenjie
 * @date : 2018-12-24 9:43
 * @describe :
 */
@RestController
@RequestMapping("/one")
public class OtherTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/my")
    public String my() {
        Criteria regex = Criteria.where("user_name").regex("n");
        One one = mongoTemplate.findById("5c203982f62c6763140072f2", One.class);
        System.out.println(one);
        List<One> ones = mongoTemplate.find(Query.query(regex), One.class);
        System.out.println(ones);
        return  "ok";
    }
}
