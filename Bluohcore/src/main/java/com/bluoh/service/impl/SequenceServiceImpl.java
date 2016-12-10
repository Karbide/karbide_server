package com.bluoh.service.impl;

import com.bluoh.model.Sequence;
import com.bluoh.service.SequenceService;
import com.bluoh.utils.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 26-09-2016.
 */
@Service
public class SequenceServiceImpl implements SequenceService {

    private final MongoOperations mongoOperation;

    @Autowired
    public SequenceServiceImpl(MongoOperations mongoOperation) {
        this.mongoOperation = mongoOperation;
    }

    @Override
    public long getNextSequenceId(String key) throws SequenceException {
        Query query = new Query(Criteria.where("_id").is(key));

        Update update = new Update();
        update.inc("seq", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Sequence seqId = mongoOperation.findAndModify(query, update, options, Sequence.class);

        if (seqId == null) {
            throw new SequenceException("Unable to get sequence id for key : " + key);
        }

        return seqId.getSeq();
    }
}
