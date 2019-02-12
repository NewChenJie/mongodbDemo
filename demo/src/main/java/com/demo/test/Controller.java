package com.demo.test;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenjie
 * @date : 2018-12-18 11:26
 * @describe :
 */
@RestController
@RequestMapping("/test")
public class Controller {


    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/add")
    public String test() {
        //默认_id为实体的id字段，也可以用@Id来指定，不能重复
        User user = User.builder().age(2).cid("1").name("tome").build();
        User user1 = User.builder().age(2).cid("2").name("cat").build();
        ArrayList<Object> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        for (int i=0;i<50;i++) {
            User user3 = User.builder().age(2).cid("1").name("tome").build();
            user3.setAge(i);
            list.add(user3);
        }
        //实体类上的@Document可以设置默认集合名，不设置就为类名
//        mongoTemplate.insert(user);
//        mongoTemplate.insert(user, "my");
//        mongoTemplate.insert(list,User.class);
        mongoTemplate.insertAll(list);
//      save和insert基本一致，只是在指定 _id 字段，save则会更新该 _id 的数据
//        mongoTemplate.save(user);
        return "over";
    }

    @GetMapping("/remove")
    public String remove() {
        Query query = Query.query(Criteria.where("age").is(2));
        User user = User.builder().cid("1").build();
        //根据实体的ID来删除
//        mongoTemplate.remove(user);
//        mongoTemplate.remove(query, User.class);
        // 只删除第一条
        mongoTemplate.findAndRemove(query, User.class);
        return "over";
    }

    @GetMapping("/update")
    public String update() {
        Query query=new Query(Criteria.where("age").is(223));
        Update update = Update.update("name", "va");
        //只修改第一个
//        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        //全部修改
//        mongoTemplate.updateMulti(query, update, User.class);
        //不存在就添加
        mongoTemplate.upsert(query, update, User.class);
        return "update";
    }

    @GetMapping("/find")
    public String find() {
        Query query=new Query(Criteria.where("age").is(223));
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users);
        return "find";
    }

}
