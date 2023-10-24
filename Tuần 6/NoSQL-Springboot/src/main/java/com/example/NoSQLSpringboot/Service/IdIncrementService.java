package com.example.NoSQLSpringboot.Service;

import com.example.NoSQLSpringboot.Model.IdIncrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class IdIncrementService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName){
        //get current id no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update id no
        Update update = new Update().inc("number",1);
        //modify in document
        IdIncrement counter = mongoOperations
                .findAndModify(query,update,
                        options().returnNew(true).upsert(true),
                        IdIncrement.class);
        return !Objects.isNull(counter) ? counter.getNumber() : 1;
    }
}
