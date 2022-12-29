package sparta.prestudy.bucket;

import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BucketRepository {

    private final MongoTemplate mongoTemplate;

    public Long save(Bucket bucket){
        mongoTemplate.save(bucket);
        return bucket.getId();
    }

    public List<Bucket> findAll(){
        return mongoTemplate.findAll(Bucket.class);
    }

    public Long updateBucket(Long id){
        Query query = new Query();
        Update update = new Update();

        query.addCriteria(Criteria.where("_id").is(id));
        update.set("done",true);

        mongoTemplate.updateFirst(query,update,Bucket.class);
        return id;
    }
    public void clearAll(){
        mongoTemplate.dropCollection(Bucket.class);
    }
}
