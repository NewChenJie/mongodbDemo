package com.demo.mongoJPA;

import com.demo.test.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.SessionSynchronization;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;

/**
 * @author : chenjie
 * @date : 2018-12-24 10:43
 * @describe :
 */
@RestController
@RequestMapping("/jpa")
public class JPAcontroller {
    @Autowired
    private MongoMapper mongoMapper;

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/my")
    public String my() {

        return "OK";
    }
}
