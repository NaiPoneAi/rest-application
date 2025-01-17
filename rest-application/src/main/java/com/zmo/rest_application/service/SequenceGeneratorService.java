package com.zmo.rest_application.service;

import com.zmo.rest_application.model.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
    @Autowired
    private MongoOperations mongoOperations;

    public Long getSequenceNumber(String sequencename){
        //get sequence no
        Query query=new Query(Criteria.where("id").is(sequencename));
        //update sequence no
        Update update=new Update().inc("seq",1);
        //modify in document
        DbSequence counter=mongoOperations
                .findAndModify(query,
                        update,options().returnNew(true).upsert(true),
                        DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
