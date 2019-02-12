package com.demo.mongoJPA;

import com.demo.test.One;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : chenjie
 * @date : 2018-12-24 10:16
 * @describe :
 */
@Repository
public interface MongoMapper extends MongoRepository<One,Long> {
    List<One> findByUserNameLike(String userName);
}

